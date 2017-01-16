package com.ANNBets.Controllers;

import com.ANNBets.Entities.*;
import com.ANNBets.Service.*;
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
    private AdditionalStatsService additionalStatsService;

    @Autowired
    private UsualStatsService usualStatsService;

    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/parseFile")
    @ResponseBody
    public void doSmth(){

        Stats statsById = statsService.getStatsById(1L);
        int i=0;


    }
}
