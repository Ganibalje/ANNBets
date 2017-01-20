package com.ANNBets.service;

import com.ANNBets.entities.Match;
import com.ANNBets.entities.Team;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface MatchService {
    Long addMatch(Match match);
    Long updateMatch(Match match);
    List<Match> listMatch();
    Match getMatchById(Long id);
    Long removeMatch(Match match);
    Boolean isExist(Team homeTeam, Team awayTeam, Date date);
}
