package com.ANNBets.service;

import com.ANNBets.dao.PlayedMatchDao;
import com.ANNBets.entities.League;
import com.ANNBets.entities.PlayedMatch;
import com.ANNBets.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class PlayedMatchServiceImpl implements PlayedMatchService {

    @Autowired
    private PlayedMatchDao playedMatchDao;

    @Override
    @Transactional
    public Long addMatch(PlayedMatch playedMatch) {
        return playedMatchDao.addMatch(playedMatch);
    }

    @Override
    @Transactional
    public Long updateMatch(PlayedMatch playedMatch) {
        return playedMatchDao.updateMatch(playedMatch);
    }

    @Override
    @Transactional
    public List<PlayedMatch> listMatch() {
        return playedMatchDao.listMatch();
    }

    @Override
    @Transactional
    public PlayedMatch getMatchById(Long id) {
        return playedMatchDao.getMatchById(id);
    }

    @Override
    @Transactional
    public Long removeMatch(PlayedMatch playedMatch) {
        return playedMatchDao.removeMatch(playedMatch);
    }

    @Override
    @Transactional
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        return playedMatchDao.isExist(homeTeam, awayTeam, date);
    }

    @Override
    @Transactional
    public List<PlayedMatch> getListByHomeTeam(Team homeTeam) {
        return playedMatchDao.getListByHomeTeam(homeTeam);
    }

    @Override
    @Transactional
    public List<PlayedMatch> getListByAwayTeam(Team awayTeam) {
        return playedMatchDao.getListByAwayTeam(awayTeam);
    }

    @Override
    @Transactional
    public List<PlayedMatch> getListByBothTeam(Team homeTeam, Team awayTeam) {
        return playedMatchDao.getListByBothTeam(homeTeam, awayTeam);
    }

    @Override
    @Transactional
    public List<PlayedMatch> getListByLeague(League league) {
        return playedMatchDao.getListByLeague(league);
    }
}
