package com.ANNBets.service;

import com.ANNBets.entities.FutureMatch;
import com.ANNBets.entities.League;
import com.ANNBets.entities.PlayedMatch;
import com.ANNBets.entities.Team;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 14.2.17.
 */
public interface FutureMatchService {
    Long addMatch(FutureMatch playedMatch);
    Long updateMatch(FutureMatch playedMatch);
    List<FutureMatch> listMatch();
    FutureMatch getMatchById(Long id);
    Long removeMatch(FutureMatch playedMatch);
    Boolean isExist(Team homeTeam, Team awayTeam, Date date);
    List<FutureMatch> getListByHomeTeam(Team homeTeam);
    List<FutureMatch> getListByAwayTeam(Team awayTeam);
    List<FutureMatch> getListByBothTeam(Team homeTeam, Team awayTeam);
    List<FutureMatch> getListByLeague(League league);
}
