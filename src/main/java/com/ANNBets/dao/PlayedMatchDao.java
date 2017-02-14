package com.ANNBets.dao;

import com.ANNBets.entities.League;
import com.ANNBets.entities.PlayedMatch;
import com.ANNBets.entities.Team;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface PlayedMatchDao {
    Long addMatch(PlayedMatch playedMatch);
    Long updateMatch(PlayedMatch playedMatch);
    List<PlayedMatch> listMatch();
    PlayedMatch getMatchById(Long id);
    Long removeMatch(PlayedMatch playedMatch);
    Boolean isExist(Team homeTeam, Team awayTeam, Date date);
    List<PlayedMatch> getListByHomeTeam(Team homeTeam);
    List<PlayedMatch> getListByAwayTeam(Team awayTeam);
    List<PlayedMatch> getListByBothTeam(Team homeTeam, Team awayTeam);
    List<PlayedMatch> getListByLeague(League league);
}
