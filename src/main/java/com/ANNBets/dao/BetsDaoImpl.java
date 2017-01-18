package com.ANNBets.dao;

import com.ANNBets.entities.Bets;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class BetsDaoImpl implements BetsDao{

    private SessionFactory sessionFactory;

    public BetsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addBets(Bets bets) {
        return (Long)sessionFactory.getCurrentSession().save(bets);
    }

    @Override
    public Long updateBets(Bets bets) {
        sessionFactory.getCurrentSession().update(bets);
        return bets.getId();
    }

    @Override
    public List<Bets> listBets() {
        return sessionFactory.getCurrentSession().createQuery("from Bets").list();
    }

    @Override
    public Bets getBetsById(Long id) {
        return sessionFactory.getCurrentSession().get(Bets.class, id);
    }

    @Override
    public Long removeBets(Bets bets) {
        sessionFactory.getCurrentSession().delete(bets);
        return bets.getId();
    }
}
