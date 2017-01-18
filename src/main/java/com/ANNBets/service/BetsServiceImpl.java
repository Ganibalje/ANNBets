package com.ANNBets.service;

import com.ANNBets.dao.BetsDao;
import com.ANNBets.entities.Bets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class BetsServiceImpl implements BetsService {

    @Autowired
    private BetsDao betsDao;

    @Override
    @Transactional
    public Long addBets(Bets bets) {
        return betsDao.addBets(bets);
    }

    @Override
    @Transactional
    public Long updateBets(Bets bets) {
        return betsDao.updateBets(bets);
    }

    @Override
    @Transactional
    public List<Bets> listBets() {
        return betsDao.listBets();
    }

    @Override
    @Transactional
    public Bets getBetsById(Long id) {
        return betsDao.getBetsById(id);
    }

    @Override
    @Transactional
    public Long removeBets(Bets bets) {
        return betsDao.removeBets(bets);
    }
}
