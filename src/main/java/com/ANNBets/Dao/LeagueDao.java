package com.ANNBets.Dao;

import com.ANNBets.Entities.League;
import com.ANNBets.Entities.Referee;

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
}
