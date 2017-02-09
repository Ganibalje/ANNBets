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
    private MatchService autowiredMatchService;
    private static MatchService matchService;

    @Autowired
    private UsualStatsService autowiredUsualStatsService;
    private static UsualStatsService usualStatsService;

    @Autowired
    private AdditionalStatsService autowiredAdditionalStatsService;
    private static AdditionalStatsService additionalStatsService;

    @Autowired
    private StatsService autowiredStatsService;
    private static StatsService statsService;

    @PostConstruct
    public void initStaticService() {
        leagueService = this.autowiredLeagueService;
        teamService = this.autowiredTeamService;
        refereeService = this.autowiredRefereeService;
        matchService = this.autowiredMatchService;
        usualStatsService = this.autowiredUsualStatsService;
        additionalStatsService = this.autowiredAdditionalStatsService;
        statsService = this.autowiredStatsService;
    }

    public static void parse(String url, String username, String password) throws IOException, ParseException {
        Connection.Response response = Jsoup.connect(url)
                .data("login", username, "password", password)
                .method(Connection.Method.POST)
                .execute();
        Map<String, String> cookies = response.cookies();

        for(int i=25418;i<150000;i++){
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
                if(!matchService.isExist(homeTeam, awayTeam, dateOfMatch)) {
                    UsualStats usualStats = getUsualStats(information);
                    AdditionalStats additionalStats = getAdditionalStats(information);

                    Stats stats = new Stats();
                    stats.setUsualStats(usualStats);
                    stats.setAdditionalStats(additionalStats);
                    Stats statsById = statsService.getStatsById(statsService.addStats(stats));

                    Match match = new Match();
                    match.setDate(dateOfMatch);
                    match.setHomeTeam(homeTeam);
                    match.setAwayTeam(awayTeam);
                    match.setStats(statsById);
                    match.setReferee(referee);

                    matchService.addMatch(match);
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
        int homeGoals = Integer.valueOf(score_goals.get(1).text());
        int awayGoals = Integer.valueOf(score_goals.get(3).text());

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
        usualStats.setFTHG(homeGoals);
        usualStats.setFTAG(awayGoals);
        usualStats.setFTR(getScoreResult(homeGoals, awayGoals));

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
        Elements corners = other.get(1).getAllElements();
        if(!corners.get(1).text().equals("?") && !corners.get(5).text().equals("")) {
            additionalStats.setHC(Integer.valueOf(corners.get(1).text().substring(0, 1)));
            additionalStats.setAC(Integer.valueOf(corners.get(5).text().substring(0, 1)));
        }

        Integer homeShotsOnTarget = null;
        Integer awayShotsOnTarget = null;
        if(other.size() > 7) {
            Elements shotsOnTarget = other.get(7).getAllElements();
            homeShotsOnTarget = Integer.valueOf(shotsOnTarget.get(1).text());
            awayShotsOnTarget = Integer.valueOf(shotsOnTarget.get(3).text());
        }
        Integer homeShotsWide = null;
        Integer awayShotsWide = null;
        if(other.size() > 11) {
            Elements shotsWide = other.get(11).getAllElements();
            homeShotsWide = Integer.valueOf(shotsWide.get(1).text());
            awayShotsWide = Integer.valueOf(shotsWide.get(3).text());
        }
        if(homeShotsOnTarget == null && homeShotsWide == null)
            additionalStats.setHS(null);
        else
            additionalStats.setHS(homeShotsOnTarget + homeShotsWide);
        if(awayShotsOnTarget == null && awayShotsWide == null)
            additionalStats.setAS(null);
        else
            additionalStats.setAS(awayShotsOnTarget + awayShotsWide);

        additionalStats.setHST(homeShotsOnTarget);
        additionalStats.setAST(awayShotsOnTarget);

        if(other.size() > 15) {
            Elements fouls = other.get(15).getAllElements();
            if(!fouls.get(1).text().equals("?") && !fouls.get(3).text().equals("?")) {
                additionalStats.setHF(Integer.valueOf(fouls.get(1).text()));
                additionalStats.setAF(Integer.valueOf(fouls.get(3).text()));
            }
        }

        if(other.size() > 19) {
            Elements offsides = other.get(19).getAllElements();
            additionalStats.setHO(Integer.valueOf(offsides.get(1).text()));
            additionalStats.setAO(Integer.valueOf(offsides.get(3).text()));
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
