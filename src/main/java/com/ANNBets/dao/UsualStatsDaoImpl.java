package com.ANNBets.dao;

import com.ANNBets.entities.UsualStats;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Repository
public class UsualStatsDaoImpl implements UsualStatsDao {

    private SessionFactory sessionFactory;

    public UsualStatsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addUsualStats(UsualStats usualStats) {
        return (Long)sessionFactory.getCurrentSession().save(usualStats);
    }

    @Override
    public Long updateUsualStats(UsualStats usualStats) {
        sessionFactory.getCurrentSession().update(usualStats);
        return usualStats.getId();
    }

    @Override
    public List<UsualStats> listUsualStatss() {
        return sessionFactory.getCurrentSession().createQuery("from Usual_stats").list();
    }

    @Override
    public UsualStats getUsualStatsById(Long id) {
        return sessionFactory.getCurrentSession().get(UsualStats.class, id);
    }

    @Override
    public Long removeUsualStats(UsualStats usualStats) {
        sessionFactory.getCurrentSession().delete(usualStats);
        return usualStats.getId();
    }
}
