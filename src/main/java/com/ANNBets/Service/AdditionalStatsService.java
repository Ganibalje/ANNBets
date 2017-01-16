package com.ANNBets.Service;

import com.ANNBets.Entities.AdditionalStats;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface AdditionalStatsService {
    Long addAdditionalStats(AdditionalStats additionalStats);
    Long updateAdditionalStats(AdditionalStats additionalStats);
    List<AdditionalStats> listAdditionalStatss();
    AdditionalStats getAdditionalStatsById(Long id);
    Long removeAdditionalStats(AdditionalStats additionalStats);
}
