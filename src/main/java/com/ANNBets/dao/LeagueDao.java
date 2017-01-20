package com.ANNBets.dao;

import com.ANNBets.entities.League;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface LeagueDao {
    Long addLeague(League league);
    Long updateLeague(League league);
    List<League> listLeagues();
    League getLeagueById(Long id);
    Long removeLeague(League league);
    Boolean isExistByName(String name);
    League getLeagueByName(String name);
}
