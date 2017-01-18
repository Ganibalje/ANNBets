package com.ANNBets.service;

import com.ANNBets.dao.TeamDao;
import com.ANNBets.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional
    public Long addTeam(Team team) {
        return teamDao.addTeam(team);
    }

    @Override
    @Transactional
    public Long updateTeam(Team team) {
        return teamDao.updateTeam(team);
    }

    @Override
    @Transactional
    public List<Team> listTeams() {
        return teamDao.listTeams();
    }

    @Override
    @Transactional
    public Team getTeamById(Long id) {
        return teamDao.getTeamById(id);
    }

    @Override
    @Transactional
    public Long removeTeam(Team team) {
        return teamDao.removeTeam(team);
    }


}
