package com.ANNBets.dao;

import com.ANNBets.entities.BbOUBets;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class BbOUBetsDaoImpl implements BbOUBetsDao {

    private SessionFactory sessionFactory;

    public BbOUBetsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addBbOUBets(BbOUBets bbOUBets) {
        return (Long)sessionFactory.getCurrentSession().save(bbOUBets);
    }

    @Override
    public Long updateBbOUBets(BbOUBets bbOUBets) {
        sessionFactory.getCurrentSession().update(bbOUBets);
        return bbOUBets.getId();
    }

    @Override
    public List<BbOUBets> listBbOUBets() {
        return sessionFactory.getCurrentSession().createQuery("from BbOU_Bets").list();
    }

    @Override
    public BbOUBets getBbOUBetsById(Long id) {
        return sessionFactory.getCurrentSession().get(BbOUBets.class, id);
    }

    @Override
    public Long removeBbOUBets(BbOUBets bbOUBets) {
        sessionFactory.getCurrentSession().delete(bbOUBets);
        return bbOUBets.getId();
    }
}
