package com.ANNBets.service;

import com.ANNBets.dao.MatchDao;
import com.ANNBets.entities.Match;
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
public class MatchServiceImpl implements MatchService{

    @Autowired
    private MatchDao matchDao;

    @Override
    @Transactional
    public Long addMatch(Match match) {
        return matchDao.addMatch(match);
    }

    @Override
    @Transactional
    public Long updateMatch(Match match) {
        return matchDao.updateMatch(match);
    }

    @Override
    @Transactional
    public List<Match> listMatch() {
        return matchDao.listMatch();
    }

    @Override
    @Transactional
    public Match getMatchById(Long id) {
        return matchDao.getMatchById(id);
    }

    @Override
    @Transactional
    public Long removeMatch(Match match) {
        return matchDao.removeMatch(match);
    }

    @Override
    @Transactional
    public Boolean isExist(Team homeTeam, Team awayTeam, Date date) {
        return matchDao.isExist(homeTeam, awayTeam, date);
    }
}
