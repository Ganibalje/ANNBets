package com.ANNBets.service;

import com.ANNBets.dao.StatsDao;
import com.ANNBets.entities.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsDao statsDao;

    @Override
    @Transactional
    public Long addStats(Stats stats) {
        return statsDao.addStats(stats);
    }

    @Override
    @Transactional
    public Long updateStats(Stats stats) {
        return statsDao.updateStats(stats);
    }

    @Override
    @Transactional
    public List<Stats> listStats() {
        return statsDao.listStats();
    }

    @Override
    @Transactional
    public Stats getStatsById(Long id) {
        return statsDao.getStatsById(id);
    }

    @Override
    @Transactional
    public Long removeTeam(Stats stats) {
        return statsDao.removeTeam(stats);
    }
}
