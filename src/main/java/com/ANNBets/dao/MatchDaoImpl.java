package com.ANNBets.dao;

import com.ANNBets.entities.Match;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class MatchDaoImpl implements MatchDao {

    private SessionFactory sessionFactory;

    public MatchDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addMatch(Match match) {
        return (Long)sessionFactory.getCurrentSession().save(match);
    }

    @Override
    public Long updateMatch(Match match) {
        sessionFactory.getCurrentSession().update(match);
        return match.getId();
    }

    @Override
    public List<Match> listMatch() {
        return sessionFactory.getCurrentSession().createQuery("from Match").list();
    }

    @Override
    public Match getMatchById(Long id) {
        return sessionFactory.getCurrentSession().get(Match.class, id);
    }

    @Override
    public Long removeMatch(Match match) {
        sessionFactory.getCurrentSession().delete(match);
        return match.getId();
    }
}
