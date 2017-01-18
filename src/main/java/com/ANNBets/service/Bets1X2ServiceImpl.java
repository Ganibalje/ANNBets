package com.ANNBets.service;

import com.ANNBets.dao.Bets1X2Dao;
import com.ANNBets.entities.Bets1X2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class Bets1X2ServiceImpl implements Bets1X2Service {

    @Autowired
    private Bets1X2Dao bets1X2Dao;

    @Override
    @Transactional
    public Long addBets1X2(Bets1X2 bets1X2) {
        return bets1X2Dao.addBets1X2(bets1X2);
    }

    @Override
    @Transactional
    public Long updateBets1X2(Bets1X2 bets1X2) {
        return bets1X2Dao.updateBets1X2(bets1X2);
    }

    @Override
    @Transactional
    public List<Bets1X2> listBets1X2() {
        return bets1X2Dao.listBets1X2();
    }

    @Override
    @Transactional
    public Bets1X2 getBets1X2ById(Long id) {
        return bets1X2Dao.getBets1X2ById(id);
    }

    @Override
    @Transactional
    public Long removeBets1X2(Bets1X2 bets1X2) {
        return bets1X2Dao.removeBets1X2(bets1X2);
    }
}
