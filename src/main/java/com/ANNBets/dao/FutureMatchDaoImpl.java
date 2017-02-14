package com.ANNBets.dao;

import com.ANNBets.entities.FutureMatch;
import com.ANNBets.entities.League;
import com.ANNBets.entities.PlayedMatch;
import com.ANNBets.entities.Team;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 14.2.17.
 */
@Repository
public class FutureMatchDaoImpl implements FutureMatchDao {
    private SessionFactory sessionFactory;

    public FutureMatchDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addMatch(FutureMatch futureMatch) {
        return (Long)sessionFactory.getCurrentSession().save(futureMatch);
    }

    @Override
    public Long updateMatch(FutureMatch futureMatch) {
        sessionFactory.getCurrentSession().update(futureMatch);
        return futureMatch.getId();
    }

    @Override
    public List<FutureMatch> listMatch() {
        return sessionFactory.getCurrentSession().createQuery("from FutureMatch").list();
    }

    @Override
    public FutureMatch getMatchById(Long id) {
        return sessionFactory.getCurrentSession().get(FutureMatch.class, id);
    }

    @Override
    public Long removeMatch(FutureMatch futureMatch) {
        sessionFactory.getCurrentSession().delete(futureMatch);
        return futureMatch.getId();
    }

    @Override
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        FutureMatch futureMatch = (FutureMatch) sessionFactory.getCurrentSession().createQuery("from FutureMatch where homeTeam=:homeTeam and awayTeam=:awayTeam and date=:date")
                .setParameter("homeTeam", homeTeam)
                .setParameter("awayTeam", awayTeam)
                .setParameter("date", date)
                .uniqueResult();
        return futureMatch != null;
    }

    @Override
    public List<FutureMatch> getListByHomeTeam(Team homeTeam) {
        return sessionFactory.getCurrentSession().createQuery("from FutureMatch where homeTeam=:homeTeam")
                .setParameter("homeTeam", homeTeam).list();
    }

    @Override
    public List<FutureMatch> getListByAwayTeam(Team awayTeam) {
        return sessionFactory.getCurrentSession().createQuery("from FutureMatch where awayTeam=:awayTeam")
                .setParameter("awayTeam", awayTeam).list();
    }

    @Override
    public List<FutureMatch> getListByBothTeam(Team homeTeam, Team awayTeam) {
        return sessionFactory.getCurrentSession().createQuery("from FutureMatch where homeTeam=:homeTeam and awayTeam=:awayTeam")
                .setParameter("homeTeam", homeTeam)
                .setParameter("awayTeam", awayTeam).list();
    }

    @Override
    public List<FutureMatch> getListByLeague(League league) {
        return sessionFactory.getCurrentSession().createQuery("from FutureMatch where homeTeam.league=:league and awayTeam.league=:league")
                .setParameter("league", league).list();
    }
}
