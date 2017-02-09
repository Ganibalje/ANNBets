package com.ANNBets.controllers;

import com.ANNBets.ann.ANNDataSupplier;
import com.ANNBets.ann.ANNExecutor;
import com.ANNBets.dto.Prepared1X2Data;
import com.ANNBets.entities.League;
import com.ANNBets.entities.Team;
import com.ANNBets.parser.Parser;
import com.ANNBets.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
@Controller
public class HomeController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private LeagueService leagueService;

    @RequestMapping(value = "/doANN")
    @ResponseBody
    public void doSmth(){

//        League leagueById = leagueService.getLeagueById(1L);

//        ANNDataSupplier.writeTraingingDataToFile(leagueById);
//        Team homeTeam = teamService.getTeamByName("Man United");
//        Team awayTeam = teamService.getTeamByName("Newcastle");
//        Prepared1X2Data prepare = ANNDataSupplier.prepare(homeTeam, awayTeam);

        ANNExecutor annExecutor = new ANNExecutor();
        annExecutor.doANN();
        int i=0;
    }

    @RequestMapping(value = "/checkANN")
    @ResponseBody
    public void checkANN(){
        Team homeTeam = teamService.getTeamByName("Man City");
        Team awayTeam = teamService.getTeamByName("Sunderland");
        ANNExecutor annExecutor = new ANNExecutor();
        annExecutor.getPrediction(homeTeam, awayTeam);
    }
}
