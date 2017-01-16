package com.ANNBets.Dao;

import com.ANNBets.Entities.League;
import com.ANNBets.Entities.Team;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
public interface TeamDao {
    Long addTeam(Team team);
    Long updateTeam(Team team);
    List<Team> listTeams();
    Team getTeamById(Long id);
    Long removeTeam(Team team);
}
