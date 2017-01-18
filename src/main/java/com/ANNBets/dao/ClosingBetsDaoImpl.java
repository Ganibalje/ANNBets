package com.ANNBets.dao;

import com.ANNBets.entities.AdditionalStats;
import com.ANNBets.entities.ClosingBets;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class ClosingBetsDaoImpl implements ClosingBetsDao {

    private SessionFactory sessionFactory;

    public ClosingBetsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addClosingBets(ClosingBets closingBets) {
        return (Long)sessionFactory.getCurrentSession().save(closingBets);
    }

    @Override
    public Long updateClosingBets(ClosingBets closingBets) {
        sessionFactory.getCurrentSession().update(closingBets);
        return closingBets.getId();
    }

    @Override
    public List<ClosingBets> listClosingBets() {
        return sessionFactory.getCurrentSession().createQuery("from Closing_Bets").list();
    }

    @Override
    public ClosingBets getClosingBetsById(Long id) {
        return sessionFactory.getCurrentSession().get(ClosingBets.class, id);
    }

    @Override
    public Long removeClosingBets(ClosingBets closingBets) {
        sessionFactory.getCurrentSession().delete(closingBets);
        return closingBets.getId();
    }
}
