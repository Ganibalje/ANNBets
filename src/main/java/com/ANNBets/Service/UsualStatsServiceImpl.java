package com.ANNBets.Service;

import com.ANNBets.Dao.UsualStatsDao;
import com.ANNBets.Entities.UsualStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Service
public class UsualStatsServiceImpl implements UsualStatsService {

    @Autowired
    private UsualStatsDao usualStatsDao;

    @Override
    @Transactional
    public Long addUsualStats(UsualStats usualStats) {
        return usualStatsDao.addUsualStats(usualStats);
    }

    @Override
    @Transactional
    public Long updateUsualStats(UsualStats usualStats) {
        return usualStatsDao.updateUsualStats(usualStats);
    }

    @Override
    @Transactional
    public List<UsualStats> listUsualStatss() {
        return usualStatsDao.listUsualStatss();
    }

    @Override
    @Transactional
    public UsualStats getUsualStatsById(Long id) {
        return usualStatsDao.getUsualStatsById(id);
    }

    @Override
    @Transactional
    public Long removeUsualStats(UsualStats usualStats) {
        return usualStatsDao.removeUsualStats(usualStats);
    }
}
