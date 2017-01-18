package com.ANNBets.dao;

import com.ANNBets.entities.Referee;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
@Repository
public class RefereeDaoImpl implements RefereeDao {
    private static final Logger logger = LoggerFactory.getLogger(RefereeDaoImpl.class);

    private SessionFactory sessionFactory;

    public RefereeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addReferee(Referee referee) {
        return (Long)sessionFactory.getCurrentSession().save(referee);
    }

    @Override
    public Long updateReferee(Referee referee) {
        sessionFactory.getCurrentSession().update(referee);
        return referee.getId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Referee> listReferees() {
        return sessionFactory.getCurrentSession().createQuery("from Referee").list();
    }

    @Override
    public Referee getRefereeById(Long id) {
        return sessionFactory.getCurrentSession().get(Referee.class, id);
    }

    @Override
    public Long removeReferee(Referee referee) {
        sessionFactory.getCurrentSession().delete(referee);
        return referee.getId();
    }
}
