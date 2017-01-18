package com.ANNBets.dao;

import com.ANNBets.entities.Bb1X2Bets;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class Bb1X2BetsDaoImpl implements Bb1X2BetsDao {

    private SessionFactory sessionFactory;

    public Bb1X2BetsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        return (Long)sessionFactory.getCurrentSession().save(bb1X2Bets);
    }

    @Override
    public Long updateBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        sessionFactory.getCurrentSession().update(bb1X2Bets);
        return bb1X2Bets.getId();
    }

    @Override
    public List<Bb1X2Bets> listBb1X2Bets() {
        return sessionFactory.getCurrentSession().createQuery("from Bb1X2_Bets").list();
    }

    @Override
    public Bb1X2Bets getBb1X2BetsById(Long id) {
        return sessionFactory.getCurrentSession().get(Bb1X2Bets.class, id);
    }

    @Override
    public Long removeBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        sessionFactory.getCurrentSession().delete(bb1X2Bets);
        return bb1X2Bets.getId();
    }
}
