package com.ANNBets.dao;


import com.ANNBets.entities.Bets1X2;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class Bets1X2DaoImpl implements Bets1X2Dao {

    private SessionFactory sessionFactory;

    public Bets1X2DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addBets1X2(Bets1X2 bets1X2) {
        return (Long)sessionFactory.getCurrentSession().save(bets1X2);
    }

    @Override
    public Long updateBets1X2(Bets1X2 bets1X2) {
        sessionFactory.getCurrentSession().update(bets1X2);
        return bets1X2.getId();
    }

    @Override
    public List<Bets1X2> listBets1X2() {
        return sessionFactory.getCurrentSession().createQuery("from 1X2_Bets").list();
    }

    @Override
    public Bets1X2 getBets1X2ById(Long id) {
        return sessionFactory.getCurrentSession().get(Bets1X2.class, id);
    }

    @Override
    public Long removeBets1X2(Bets1X2 bets1X2) {
        sessionFactory.getCurrentSession().delete(bets1X2);
        return bets1X2.getId();
    }
}
