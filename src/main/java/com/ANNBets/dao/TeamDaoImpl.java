package com.ANNBets.dao;

import com.ANNBets.entities.Team;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Repository
public class TeamDaoImpl implements TeamDao {

    private SessionFactory sessionFactory;

    public TeamDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addTeam(Team team) {
        return (Long)sessionFactory.getCurrentSession().save(team);
    }

    @Override
    public Long updateTeam(Team team) {
        sessionFactory.getCurrentSession().update(team);
        return team.getId();
    }

    @Override
    public List<Team> listTeams() {
        return sessionFactory.getCurrentSession().createQuery("from Team").list();
    }

    @Override
    public Team getTeamById(Long id) {
        return sessionFactory.getCurrentSession().get(Team.class, id);
    }

    @Override
    public Long removeTeam(Team team) {
        sessionFactory.getCurrentSession().delete(team);
        return team.getId();
    }
}
