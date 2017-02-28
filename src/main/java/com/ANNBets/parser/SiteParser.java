package com.ANNBets.parser;

import com.ANNBets.entities.*;
import com.ANNBets.service.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by siarhei_beliabniou on 6.2.17.
 */
@Component
public class SiteParser {

    private static final String PARSE_URL = "http://corner-stats.com/man-utd-watford-11-02-2017/premier-league-england/match/";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");

    @Autowired
    private LeagueService autowiredLeagueService;
    private static LeagueService leagueService;

    @Autowired
    private TeamService autowiredTeamService;
    private static TeamService teamService;

    @Autowired
    private RefereeService autowiredRefereeService;
    private static RefereeService refereeService;

    @Autowired
    private PlayedMatchService autowiredPlayedMatchService;
    private static PlayedMatchService playedMatchService;

    @Autowired
    private UsualStatsService autowiredUsualStatsService;
    private static UsualStatsService usualStatsService;

    @Autowired
    private AdditionalStatsService autowiredAdditionalStatsService;
    private static AdditionalStatsService additionalStatsService;

    @Autowired
    private StatsService autowiredStatsService;
    private static StatsService statsService;

    @Autowired
    private FutureMatchService autowiredFutureMatchService;
    private static FutureMatchService futureMatchService;

    @PostConstruct
    public void initStaticService() {
        leagueService = this.autowiredLeagueService;
        teamService = this.autowiredTeamService;
        refereeService = this.autowiredRefereeService;
        playedMatchService = this.autowiredPlayedMatchService;
        usualStatsService = this.autowiredUsualStatsService;
        additionalStatsService = this.autowiredAdditionalStatsService;
        statsService = this.autowiredStatsService;
        futureMatchService = this.autowiredFutureMatchService;
    }

    public static void parse(String url, String username, String password) throws IOException, ParseException {
        Connection.Response response = Jsoup.connect(url)
                .data("login", username, "password", password)
                .method(Connection.Method.POST)
                .timeout(Integer.MAX_VALUE)
                .execute();
        Map<String, String> cookies = response.cookies();

        for(int i=123164;i<140000;i++){
            System.out.println(i);
            Document document = Jsoup.connect(PARSE_URL + i)
                    .cookies(cookies)
                    .timeout(Integer.MAX_VALUE)
                    .get();
            Element center = document.getElementById("center");
            Element information = document.getElementById("information");
            Date dateOfMatch = getDate(information);

            if(dateOfMatch != null){
                Referee referee = getReferee(information);
                League league = getLeague(center);
                Team homeTeam = getHomeTeam(center, league);
                Team awayTeam = getAwayTeam(center, league);
                if(dateOfMatch.getTime() < new Date().getTime()){
                    if(!playedMatchService.isExist(homeTeam, awayTeam, dateOfMatch)) {
                        UsualStats usualStats = getUsualStats(information);
                        if(usualStats == null)
                            continue;
                        AdditionalStats additionalStats = getAdditionalStats(information);

                        Stats stats = new Stats();
                        stats.setUsualStats(usualStats);
                        stats.setAdditionalStats(additionalStats);
                        Stats statsById = statsService.getStatsById(statsService.addStats(stats));

                        PlayedMatch playedMatch = new PlayedMatch();
                        playedMatch.setDate(dateOfMatch);
                        playedMatch.setHomeTeam(homeTeam);
                        playedMatch.setAwayTeam(awayTeam);
                        playedMatch.setStats(statsById);
                        playedMatch.setReferee(referee);

                        playedMatchService.addMatch(playedMatch);
                    }
                }
                else {
                    if(!futureMatchService.isExist(homeTeam, awayTeam, dateOfMatch)) {
                        FutureMatch futureMatch = new FutureMatch();
                        futureMatch.setDate(dateOfMatch);
                        futureMatch.setHomeTeam(homeTeam);
                        futureMatch.setAwayTeam(awayTeam);
                        futureMatch.setReferee(referee);

                        futureMatchService.addMatch(futureMatch);
                    }
                }

            }
        }

    }

    private static Date getDate(Element element) throws ParseException {
        Element parent = element.getElementsContainingOwnText("Match start:").parents().get(0).parent();
        String text = parent.getAllElements().get(4).text().trim();
        return text.equals("") ? null : FORMATTER.parse(text);
    }

    private static Referee getReferee(Element element){
        Element parent = element.getElementsContainingOwnText("Referee:").parents().get(0).parent();
        String referee = parent.getAllElements().get(5).text().trim();
        if(!referee.equals("")){
            return refereeService.isExistByName(referee) ? refereeService.getRefereeByName(referee)
                    : refereeService.getRefereeById(refereeService.addReferee(new Referee(referee)));
        }
        return null;
    }

    private static League getLeague(Element element){
        String text = element.getAllElements().get(1).getAllElements().text();
        String[] splited = text.split("\\.");
        String leagueName = splited[1].replace(Character.toString((char) 160), "").trim();
        if(!leagueName.equals("")){
            return leagueService.isExistByName(leagueName) ? leagueService.getLeagueByName(leagueName)
                    : leagueService.getLeagueById(leagueService.addLeague(new League(leagueName)));
        }
        return null;
    }

    private static Team getHomeTeam(Element element, League league){
        String text = element.getAllElements().get(1).getAllElements().text();
        String[] split = text.split("\\.");
        String teams = split[2].replace(Character.toString((char) 160), "").trim();
        String homeTeam = teams.split("-")[0].trim();
        if(!homeTeam.equals("")){
            return teamService.isExistByName(homeTeam) ? teamService.getTeamByName(homeTeam)
                    : teamService.getTeamById(teamService.addTeam(new Team(homeTeam, league)));
        }
        return null;
    }

    private static Team getAwayTeam(Element element, League league){
        String text = element.getAllElements().get(1).getAllElements().text();
        String[] split = text.split("\\.");
        if(split.length>3){
            for(int i=3;i<split.length;i++) {
                split[2] += split[i];
            }
        }
        String teams = split[2].replace(Character.toString((char) 160), "").trim();
        String awayTeam = teams.split("-")[1].trim();
        if(!awayTeam.equals("")){
            return teamService.isExistByName(awayTeam) ? teamService.getTeamByName(awayTeam)
                    : teamService.getTeamById(teamService.addTeam(new Team(awayTeam, league)));
        }
        return null;
    }

    private static UsualStats getUsualStats(Element element){
        UsualStats usualStats = new UsualStats();

        Elements score_goals = element.getElementById("score_text").getAllElements().get(1).getAllElements().get(1)
                .getAllElements().get(1).getAllElements().get(1).getAllElements();
        if(!score_goals.get(1).text().equals("?") && !score_goals.get(3).text().equals("?")) {
            int homeGoals = Integer.valueOf(score_goals.get(1).text());
            int awayGoals = Integer.valueOf(score_goals.get(3).text());
            usualStats.setFTHG(homeGoals);
            usualStats.setFTAG(awayGoals);
            usualStats.setFTR(getScoreResult(homeGoals, awayGoals));
        }
        else return null;

        Element scoreGoals = element.getElementById("score_goals");
        Elements scoreGoalsDetails = scoreGoals.getElementsByClass("gameDetails1");

        int HTHG = 0;
        int HTAG = 0;
        for (Element scoreGoalsDetail : scoreGoalsDetails) {
            String homeGoalElement = scoreGoalsDetail.getAllElements().get(1).text();
            String awayGoalElement = scoreGoalsDetail.getAllElements().get(6).text();

            if(!homeGoalElement.equals(""))
                if(Integer.valueOf(homeGoalElement.replace("'","")) < 46)
                    HTHG++;
            if(!awayGoalElement.equals(""))
                if(Integer.valueOf(awayGoalElement.replace("'","")) < 46)
                    HTAG++;
        }

        usualStats.setHTHG(HTHG);
        usualStats.setHTAG(HTAG);
        usualStats.setHTR(getScoreResult(HTHG, HTAG));

        return usualStatsService.getUsualStatsById(usualStatsService.addUsualStats(usualStats));
    }

    private static AdditionalStats getAdditionalStats(Element element){
        AdditionalStats additionalStats = new AdditionalStats();
        Elements cards = element.getElementById("score_cards").getAllElements().get(1).getAllElements().get(1).getAllElements();
        Elements yellowCards = cards.get(1).getAllElements();
        Elements redCards = cards.get(6).getAllElements();

        if(!yellowCards.get(1).text().equals("?") && !yellowCards.get(4).text().equals("?")) {
            additionalStats.setHY(Integer.valueOf(yellowCards.get(1).text()));
            additionalStats.setAY(Integer.valueOf(yellowCards.get(4).text()));
        }
        if(!redCards.get(1).text().equals("?") && !redCards.get(4).text().equals("?")) {
            additionalStats.setHR(Integer.valueOf(redCards.get(1).text()));
            additionalStats.setAR(Integer.valueOf(redCards.get(4).text()));
        }

        Elements other = element.getElementById("score_other").getAllElements().get(1).getAllElements().get(1).getAllElements();
        for(Element additionalStatsElement : other){
            switch (additionalStatsElement.text()){
                case "Corners 1 half in brackets":
                    Elements allElements = additionalStatsElement.parent().getAllElements();
                    if(!allElements.get(1).text().equals("?") && !allElements.get(5).text().equals("?")){
                        String HCorners = allElements.get(1).text();
                        String ACorners = allElements.get(5).text();

                        if(HCorners.indexOf(' ') != -1) {
                            additionalStats.setHC(Integer.valueOf(HCorners.substring(0, HCorners.indexOf(' '))));
                            additionalStats.setAC(Integer.valueOf(ACorners.substring(0, ACorners.indexOf(' '))));
                        }
                        else{
                            additionalStats.setHC(Integer.valueOf(HCorners));
                            additionalStats.setAC(Integer.valueOf(ACorners));
                        }
                    }
                    break;
                case "Total shots":
                    allElements = additionalStatsElement.parent().getAllElements();
                    if(!allElements.get(1).text().equals("?") && !allElements.get(3).text().equals("?")){
                        additionalStats.setHS(Integer.valueOf(allElements.get(1).text()));
                        additionalStats.setAS(Integer.valueOf(allElements.get(3).text()));
                    }
                    break;
                case "Shots on target":
                    allElements = additionalStatsElement.parent().getAllElements();
                    if(!allElements.get(1).text().equals("?") && !allElements.get(3).text().equals("?")){
                        additionalStats.setHST(Integer.valueOf(allElements.get(1).text()));
                        additionalStats.setAST(Integer.valueOf(allElements.get(3).text()));
                    }
                    break;
                case "Fouls":
                    allElements = additionalStatsElement.parent().getAllElements();
                    if(!allElements.get(1).text().equals("?") && !allElements.get(3).text().equals("?")){
                        additionalStats.setHF(Integer.valueOf(allElements.get(1).text()));
                        additionalStats.setAF(Integer.valueOf(allElements.get(3).text()));
                    }
                    break;
                case "Offsides":
                    allElements = additionalStatsElement.parent().getAllElements();
                    if(!allElements.get(1).text().equals("?") && !allElements.get(3).text().equals("?")){
                        additionalStats.setHO(Integer.valueOf(allElements.get(1).text()));
                        additionalStats.setAO(Integer.valueOf(allElements.get(3).text()));
                    }
                    break;

            }
        }

        return additionalStatsService.getAdditionalStatsById(additionalStatsService.addAdditionalStats(additionalStats));
    }






    private static String getScoreResult(int home, int away){
        if(home > away)
            return "H";
        else{
            if(home < away)
                return "A";
            else return "D";
        }
    }
}