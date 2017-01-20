package com.ANNBets.controllers;

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
    private FileService fileService;

    @RequestMapping(value = "/parseFile")
    @ResponseBody
    public void doSmth(){

        Parser.doParsing(fileService.getFileById(2L));

    }
}
