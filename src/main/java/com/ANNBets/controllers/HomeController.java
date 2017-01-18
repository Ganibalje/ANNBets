package com.ANNBets.controllers;

import com.ANNBets.entities.*;
import com.ANNBets.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
@Controller
public class HomeController {

    @Autowired
    private Bets1X2Service bets1X2Service;

    @Autowired
    private Bb1X2BetsService bb1X2BetsService;

    @Autowired
    private BbOUBetsService bbOUBetsService;

    @Autowired
    private BbAHBetsService bbAHBetsService;

    @Autowired
    private ClosingBetsService closingBetsService;

    @Autowired
    private BetsService betsService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/parseFile")
    @ResponseBody
    public void doSmth(){
        Bets1X2 bets1X2 = new Bets1X2();
        bets1X2.setB365A(1.3F);
        Long bets1X2SavedID = bets1X2Service.addBets1X2(bets1X2);
        Bets1X2 bets1X2ById = bets1X2Service.getBets1X2ById(bets1X2SavedID);

        Bb1X2Bets bb1X2Bets = new Bb1X2Bets();
        bb1X2Bets.setBbAvA(2.1F);
        Long bb1X2BetsSavedID = bb1X2BetsService.addBb1X2Bets(bb1X2Bets);
        Bb1X2Bets bb1X2BetsById = bb1X2BetsService.getBb1X2BetsById(bb1X2BetsSavedID);

        BbOUBets bbOUBets = new BbOUBets();
        bb1X2Bets.setBbAvA(3.6F);
        Long bbOUBetsSavedId = bbOUBetsService.addBbOUBets(bbOUBets);
        BbOUBets bbOUBetsById = bbOUBetsService.getBbOUBetsById(bbOUBetsSavedId);

        BbAHBets bbAHBets = new BbAHBets();
        bbAHBets.setB365AH(6F);
        Long bbAHBetsSavedID = bbAHBetsService.addBbAHBets(bbAHBets);
        BbAHBets bbAHBetsById = bbAHBetsService.getBbAHBetsById(bbAHBetsSavedID);

        ClosingBets closingBets = new ClosingBets();
        closingBets.setPSCA(6.3F);
        Long closingBetsSavedID = closingBetsService.addClosingBets(closingBets);
        ClosingBets closingBetsById = closingBetsService.getClosingBetsById(closingBetsSavedID);

        Bets bets = new Bets();
        bets.setBets1X2(bets1X2ById);
        bets.setBb1X2Bets(bb1X2BetsById);
        bets.setBbOUBets(bbOUBetsById);
        bets.setBbAHBets(bbAHBetsById);
        bets.setClosingBets(closingBetsById);

        Long aLong = betsService.addBets(bets);
        Bets betsById = betsService.getBetsById(aLong);


        League league = new League();
        league.setName("English");
        League leagueById = leagueService.getLeagueById(leagueService.addLeague(league));

        Team home = new Team();
        home.setLeague(leagueById);
        home.setName("MU");
        Team homeByID = teamService.getTeamById(teamService.addTeam(home));
        Team away = new Team();
        away.setLeague(leagueById);
        away.setName("Chealsea");
        Team awayByID = teamService.getTeamById(teamService.addTeam(away));

        Match match = new Match();
        match.setDate(new Date());
        System.out.println(match.getDate());
        System.out.println("Date "+match.getDate().getDate()+"; Month "+match.getDate().getMonth()+"; Year "+match.getDate().getYear());
        match.setHomeTeam(homeByID);
        match.setAwayTeam(awayByID);
        match.setBets(betsById);

        Match matchById = matchService.getMatchById(matchService.addMatch(match));
        int i=0;


    }
}
