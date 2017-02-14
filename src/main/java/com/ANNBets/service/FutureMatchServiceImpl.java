package com.ANNBets.service;

import com.ANNBets.dao.FutureMatchDao;
import com.ANNBets.entities.FutureMatch;
import com.ANNBets.entities.League;
import com.ANNBets.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by siarhei_beliabniou on 14.2.17.
 */
@Service
public class FutureMatchServiceImpl implements FutureMatchService{
    @Autowired
    private FutureMatchDao futureMatchDao;

    @Override
    @Transactional
    public Long addMatch(FutureMatch futureMatch) {
        return futureMatchDao.addMatch(futureMatch);
    }

    @Override
    @Transactional
    public Long updateMatch(FutureMatch futureMatch) {
        return futureMatchDao.updateMatch(futureMatch);
    }

    @Override
    @Transactional
    public List<FutureMatch> listMatch() {
        return futureMatchDao.listMatch();
    }

    @Override
    @Transactional
    public FutureMatch getMatchById(Long id) {
        return futureMatchDao.getMatchById(id);
    }

    @Override
    @Transactional
    public Long removeMatch(FutureMatch futureMatch) {
        return futureMatchDao.removeMatch(futureMatch);
    }

    @Override
    @Transactional
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        return futureMatchDao.isExist(homeTeam, awayTeam, date);
    }

    @Override
    @Transactional
    public List<FutureMatch> getListByHomeTeam(Team homeTeam) {
        return futureMatchDao.getListByHomeTeam(homeTeam);
    }

    @Override
    @Transactional
    public List<FutureMatch> getListByAwayTeam(Team awayTeam) {
        return futureMatchDao.getListByAwayTeam(awayTeam);
    }

    @Override
    @Transactional
    public List<FutureMatch> getListByBothTeam(Team homeTeam, Team awayTeam) {
        return futureMatchDao.getListByBothTeam(homeTeam, awayTeam);
    }

    @Override
    @Transactional
    public List<FutureMatch> getListByLeague(League league) {
        return futureMatchDao.getListByLeague(league);
    }
}
