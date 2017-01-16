package com.ANNBets.Service;

import com.ANNBets.Dao.AdditionalStatsDao;
import com.ANNBets.Entities.AdditionalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Service
public class AdditionalStatsServiceImpl implements AdditionalStatsService {

    @Autowired
    private AdditionalStatsDao additionalStatsDao;

    @Override
    @Transactional
    public Long addAdditionalStats(AdditionalStats additionalStats) {
        return additionalStatsDao.addAdditionalStats(additionalStats);
    }

    @Override
    @Transactional
    public Long updateAdditionalStats(AdditionalStats additionalStats) {
        return additionalStatsDao.updateAdditionalStats(additionalStats);
    }

    @Override
    @Transactional
    public List<AdditionalStats> listAdditionalStatss() {
        return additionalStatsDao.listAdditionalStatss();
    }

    @Override
    @Transactional
    public AdditionalStats getAdditionalStatsById(Long id) {
        return additionalStatsDao.getAdditionalStatsById(id);
    }

    @Override
    @Transactional
    public Long removeAdditionalStats(AdditionalStats additionalStats) {
        return additionalStatsDao.removeAdditionalStats(additionalStats);
    }
}
