package com.ANNBets.Controllers;

import com.ANNBets.Entities.Referee;
import com.ANNBets.Service.RefereeService;
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
    private RefereeService refereeService;

    @RequestMapping(value = "/parseFile")
    @ResponseBody
    public void doSmth(){
        Referee referee = new Referee();
        referee.setName("YA");

        refereeService.addReferee(referee);


    }
}
