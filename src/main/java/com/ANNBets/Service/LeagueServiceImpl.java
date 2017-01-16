package com.ANNBets.Service;

import com.ANNBets.Dao.LeagueDao;
import com.ANNBets.Entities.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ganibal on 16.1.17.
 */
@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueDao leagueDao;

    @Override
    @Transactional
    public Long addLeague(League league) {
        return leagueDao.addLeague(league);
    }

    @Override
    @Transactional
    public Long updateLeague(League league) {
        return leagueDao.updateLeague(league);
    }

    @Override
    @Transactional
    public List<League> listLeagues() {
        return leagueDao.listLeagues();
    }

    @Override
    @Transactional
    public League getLeagueById(Long id) {
        return leagueDao.getLeagueById(id);
    }

    @Override
    @Transactional
    public Long removeLeague(League league) {
        return leagueDao.removeLeague(league);
    }
}
