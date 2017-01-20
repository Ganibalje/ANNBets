package com.ANNBets.dao;

import com.ANNBets.entities.League;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Repository
public class LeagueDaoImpl implements LeagueDao {

    private SessionFactory sessionFactory;

    public LeagueDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addLeague(League league) {
        return (Long)sessionFactory.getCurrentSession().save(league);
    }

    @Override
    public Long updateLeague(League league) {
        sessionFactory.getCurrentSession().update(league);
        return league.getId();
    }

    @Override
    public List<League> listLeagues() {
        return sessionFactory.getCurrentSession().createQuery("from League").list();
    }

    @Override
    public League getLeagueById(Long id) {
        return sessionFactory.getCurrentSession().get(League.class, id);
    }

    @Override
    public Long removeLeague(League league) {
        sessionFactory.getCurrentSession().delete(league);
        return league.getId();
    }

    @Override
    public Boolean isExistByName(String name) {
        League league = (League) sessionFactory.getCurrentSession().createQuery("from League where name=:name")
                .setParameter("name", name).uniqueResult();
        return league != null;
    }

    @Override
    public League getLeagueByName(String name) {
        return (League)sessionFactory.getCurrentSession().createQuery("from League where name=:name")
                .setParameter("name", name).uniqueResult();
    }


}
