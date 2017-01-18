package com.ANNBets.dao;

import com.ANNBets.entities.UsualStats;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface UsualStatsDao {
    Long addUsualStats(UsualStats usualStats);
    Long updateUsualStats(UsualStats usualStats);
    List<UsualStats> listUsualStatss();
    UsualStats getUsualStatsById(Long id);
    Long removeUsualStats(UsualStats usualStats);
}
