package com.ANNBets.Service;

import com.ANNBets.Entities.League;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface LeagueService {
    Long addLeague(League league);
    Long updateLeague(League league);
    List<League> listLeagues();
    League getLeagueById(Long id);
    Long removeLeague(League league);
}
