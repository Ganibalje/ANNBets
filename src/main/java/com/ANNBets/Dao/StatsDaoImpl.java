package com.ANNBets.Dao;

import com.ANNBets.Entities.Stats;
import com.ANNBets.Entities.Team;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Repository
public class StatsDaoImpl implements StatsDao {

    private SessionFactory sessionFactory;

    public StatsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addStats(Stats stats) {
        return (Long)sessionFactory.getCurrentSession().save(stats);
    }

    @Override
    public Long updateStats(Stats stats) {
        sessionFactory.getCurrentSession().update(stats);
        return stats.getId();
    }

    @Override
    public List<Stats> listStats() {
        return sessionFactory.getCurrentSession().createQuery("from Stats").list();
    }

    @Override
    public Stats getStatsById(Long id) {
        return sessionFactory.getCurrentSession().get(Stats.class, id);
    }

    @Override
    public Long removeTeam(Stats stats) {
        sessionFactory.getCurrentSession().delete(stats);
        return stats.getId();
    }
}
