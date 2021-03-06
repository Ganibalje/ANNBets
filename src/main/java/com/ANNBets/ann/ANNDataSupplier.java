package com.ANNBets.ann;

import com.ANNBets.dto.Prepared1X2Data;
import com.ANNBets.entities.*;
import com.ANNBets.service.PlayedMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 27.1.17.
 */
@Component
public class ANNDataSupplier {

    @Autowired
    private PlayedMatchService autowiredPlayedMatchService;
    private static PlayedMatchService playedMatchService;

    @PostConstruct
    public void initStaticService() {
        playedMatchService = this.autowiredPlayedMatchService;
    }

    public static Prepared1X2Data prepare(Team homeTeam, Team awayTeam){
        List<PlayedMatch> listByHomeTeam = playedMatchService.getListByHomeTeam(homeTeam);
        Float last10HTHM = 0f;
        Integer count = listByHomeTeam.size();
        Float coef = 1f/count;

        for(int i=0;i<count;i++){
            UsualStats usualStats = listByHomeTeam.get(i).getStats().getUsualStats();
            switch (usualStats.getFTR()){
                case "H":{
                    last10HTHM += 1*coef;
                }
                break;
                case "A":{
                    last10HTHM += -1*coef;
                }
                break;
            }
        }

        List<PlayedMatch> listByAwayTeam = playedMatchService.getListByAwayTeam(awayTeam);
        Float last10ATAM = 0f;
        count = listByAwayTeam.size();
        coef = 1f/count;

        for(int i=0;i<count;i++){
            UsualStats usualStats = listByAwayTeam.get(i).getStats().getUsualStats();
            switch (usualStats.getFTR()){
                case "H":{
                    last10ATAM += -1*coef;
                }
                break;
                case "A":{
                    last10ATAM += 1*coef;
                }
                break;
            }
        }

        List<PlayedMatch> listByBothTeam = playedMatchService.getListByBothTeam(homeTeam, awayTeam);
        listByBothTeam.addAll(playedMatchService.getListByBothTeam(awayTeam, homeTeam));
        Float last10TvTM = 0f;
        count = listByBothTeam.size();
        coef = 1f/count;

        for(int i=0;i<count;i++){
            UsualStats usualStats = listByBothTeam.get(i).getStats().getUsualStats();
            switch (usualStats.getFTR()){
                case "H":{
                    last10TvTM += 1*coef*i;
                }
                break;
                case "D":{
                    last10TvTM *= 1f*coef*i;
                }
                break;
                case "A":{
                    last10TvTM += -1*coef;
                }
                break;
            }
        }



        Prepared1X2Data prepared1X2Data = new Prepared1X2Data(last10HTHM, last10ATAM, last10TvTM, null, null);
        return  prepared1X2Data;
    }

    public static void writeTraingingDataToFile(League league){
        List<PlayedMatch> listByLeague = playedMatchService.getListByLeague(league);

        try(FileWriter fw = new FileWriter("/home/siarhei_beliabniou/training.data", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(listByLeague.size() + " 3 3");
            for(PlayedMatch playedMatch : listByLeague){
                Prepared1X2Data prepare = prepare(playedMatch.getHomeTeam(), playedMatch.getAwayTeam());
                out.println(prepare.getLast10HTHM() + " " + prepare.getLast10ATAM() + " " + prepare.getLast10TvTM());
                String ftr = playedMatch.getStats().getUsualStats().getFTR();
                out.println((ftr.equals("H") ? "1" : "0") + " " + (ftr.equals("D") ? "1" : "0") + " " + (ftr.equals("A") ? "1" : "0"));
            }

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
