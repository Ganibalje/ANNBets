package com.ANNBets.service;

import com.ANNBets.dao.Bb1X2BetsDao;
import com.ANNBets.entities.Bb1X2Bets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class Bb1X2BetsServiceImpl implements Bb1X2BetsService {

    @Autowired
    private Bb1X2BetsDao bb1X2BetsDao;

    @Override
    @Transactional
    public Long addBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        return bb1X2BetsDao.addBb1X2Bets(bb1X2Bets);
    }

    @Override
    @Transactional
    public Long updateBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        return bb1X2BetsDao.updateBb1X2Bets(bb1X2Bets);
    }

    @Override
    @Transactional
    public List<Bb1X2Bets> listBb1X2Bets() {
        return bb1X2BetsDao.listBb1X2Bets();
    }

    @Override
    @Transactional
    public Bb1X2Bets getBb1X2BetsById(Long id) {
        return bb1X2BetsDao.getBb1X2BetsById(id);
    }

    @Override
    @Transactional
    public Long removeBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        return bb1X2BetsDao.removeBb1X2Bets(bb1X2Bets);
    }
}
