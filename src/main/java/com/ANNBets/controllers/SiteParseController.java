package com.ANNBets.controllers;

import com.ANNBets.parser.SiteParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by siarhei_beliabniou on 6.2.17.
 */
@Controller
public class SiteParseController {

    private static final String LOGIN_URL = "http://ru.corner-stats.com/index.php?route=account/login";
    private static final String USERNAME = "Heand1984@dayrep.com";
    private static final String PASSWORD = "Afbc2014";

    @RequestMapping(value = "/site")
    @ResponseBody
    public void parseSite() throws IOException, ParseException {
        SiteParser.parse(LOGIN_URL, USERNAME, PASSWORD);
    }
}
