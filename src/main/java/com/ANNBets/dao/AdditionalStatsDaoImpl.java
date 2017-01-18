package com.ANNBets.dao;

import com.ANNBets.entities.AdditionalStats;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Repository
public class AdditionalStatsDaoImpl implements AdditionalStatsDao {

    private SessionFactory sessionFactory;

    public AdditionalStatsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addAdditionalStats(AdditionalStats additionalStats) {
        return (Long)sessionFactory.getCurrentSession().save(additionalStats);
    }

    @Override
    public Long updateAdditionalStats(AdditionalStats additionalStats) {
        sessionFactory.getCurrentSession().update(additionalStats);
        return additionalStats.getId();
    }

    @Override
    public List<AdditionalStats> listAdditionalStats() {
        return sessionFactory.getCurrentSession().createQuery("from Additional_stats").list();
    }

    @Override
    public AdditionalStats getAdditionalStatsById(Long id) {
        return sessionFactory.getCurrentSession().get(AdditionalStats.class, id);
    }

    @Override
    public Long removeAdditionalStats(AdditionalStats additionalStats) {
        sessionFactory.getCurrentSession().delete(additionalStats);
        return additionalStats.getId();
    }
}
