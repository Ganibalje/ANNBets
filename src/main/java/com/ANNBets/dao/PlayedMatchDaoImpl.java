package com.ANNBets.dao;

import com.ANNBets.entities.League;
import com.ANNBets.entities.PlayedMatch;
import com.ANNBets.entities.Team;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Repository
public class PlayedMatchDaoImpl implements PlayedMatchDao {

    private SessionFactory sessionFactory;

    public PlayedMatchDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addMatch(PlayedMatch playedMatch) {
        return (Long)sessionFactory.getCurrentSession().save(playedMatch);
    }

    @Override
    public Long updateMatch(PlayedMatch playedMatch) {
        sessionFactory.getCurrentSession().update(playedMatch);
        return playedMatch.getId();
    }

    @Override
    public List<PlayedMatch> listMatch() {
        return sessionFactory.getCurrentSession().createQuery("from PlayedMatch").list();
    }

    @Override
    public PlayedMatch getMatchById(Long id) {
        return sessionFactory.getCurrentSession().get(PlayedMatch.class, id);
    }

    @Override
    public Long removeMatch(PlayedMatch playedMatch) {
        sessionFactory.getCurrentSession().delete(playedMatch);
        return playedMatch.getId();
    }

    @Override
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        PlayedMatch league = (PlayedMatch) sessionFactory.getCurrentSession().createQuery("from PlayedMatch where homeTeam=:homeTeam and awayTeam=:awayTeam and date=:date")
                .setParameter("homeTeam", homeTeam)
                .setParameter("awayTeam", awayTeam)
                .setParameter("date", date)
                .uniqueResult();
        return league != null;
    }

    @Override
    public List<PlayedMatch> getListByHomeTeam(Team homeTeam) {
        return sessionFactory.getCurrentSession().createQuery("from PlayedMatch where homeTeam=:homeTeam")
                .setParameter("homeTeam", homeTeam).list();
    }

    @Override
    public List<PlayedMatch> getListByAwayTeam(Team awayTeam) {
        return sessionFactory.getCurrentSession().createQuery("from PlayedMatch where awayTeam=:awayTeam")
                .setParameter("awayTeam", awayTeam).list();
    }

    @Override
    public List<PlayedMatch> getListByBothTeam(Team homeTeam, Team awayTeam) {
        return sessionFactory.getCurrentSession().createQuery("from PlayedMatch where homeTeam=:homeTeam and awayTeam=:awayTeam")
                .setParameter("homeTeam", homeTeam)
                .setParameter("awayTeam", awayTeam).list();
    }

    @Override
    public List<PlayedMatch> getListByLeague(League league) {
        return sessionFactory.getCurrentSession().createQuery("from PlayedMatch where homeTeam.league=:league and awayTeam.league=:league")
                .setParameter("league", league).list();
    }
}
