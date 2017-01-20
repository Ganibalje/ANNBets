package com.ANNBets.dao;

import com.ANNBets.entities.Match;
import com.ANNBets.entities.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Override
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        Match league = (Match) sessionFactory.getCurrentSession().createQuery("from Match where homeTeam=:homeTeam and awayTeam=:awayTeam and date=:date")
                .setParameter("homeTeam", homeTeam)
                .setParameter("awayTeam", awayTeam)
                .setParameter("date", date)
                .uniqueResult();
        return league != null;
    }
}
