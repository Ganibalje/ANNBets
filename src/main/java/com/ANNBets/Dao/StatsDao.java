package com.ANNBets.Dao;

import com.ANNBets.Entities.Stats;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface StatsDao {
    Long addStats(Stats stats);
    Long updateStats(Stats stats);
    List<Stats> listStats();
    Stats getStatsById(Long id);
    Long removeTeam(Stats stats);
}
