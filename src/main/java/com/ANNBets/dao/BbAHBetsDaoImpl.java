package com.ANNBets.dao;

import com.ANNBets.entities.BbAHBets;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class BbAHBetsDaoImpl implements BbAHBetsDao {

    private SessionFactory sessionFactory;

    public BbAHBetsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addBbAHBets(BbAHBets bbAHBets) {
        return (Long)sessionFactory.getCurrentSession().save(bbAHBets);
    }

    @Override
    public Long updateBbAHBets(BbAHBets bbAHBets) {
        sessionFactory.getCurrentSession().update(bbAHBets);
        return bbAHBets.getId();
    }

    @Override
    public List<BbAHBets> listBbAHBets() {
        return sessionFactory.getCurrentSession().createQuery("from BbAH_Bets").list();
    }

    @Override
    public BbAHBets getBbAHBetsById(Long id) {
        return sessionFactory.getCurrentSession().get(BbAHBets.class, id);
    }

    @Override
    public Long removeBbAHBets(BbAHBets bbAHBets) {
        sessionFactory.getCurrentSession().delete(bbAHBets);
        return bbAHBets.getId();
    }
}
