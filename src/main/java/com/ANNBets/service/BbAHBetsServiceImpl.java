package com.ANNBets.service;

import com.ANNBets.dao.BbAHBetsDao;
import com.ANNBets.entities.BbAHBets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class BbAHBetsServiceImpl implements BbAHBetsService {

    @Autowired
    private BbAHBetsDao bbAHBetsDao;

    @Override
    @Transactional
    public Long addBbAHBets(BbAHBets bbAHBets) {
        return bbAHBetsDao.addBbAHBets(bbAHBets);
    }

    @Override
    @Transactional
    public Long updateBbAHBets(BbAHBets bbAHBets) {
        return bbAHBetsDao.updateBbAHBets(bbAHBets);
    }

    @Override
    @Transactional
    public List<BbAHBets> listBbAHBets() {
        return bbAHBetsDao.listBbAHBets();
    }

    @Override
    @Transactional
    public BbAHBets getBbAHBetsById(Long id) {
        return bbAHBetsDao.getBbAHBetsById(id);
    }

    @Override
    @Transactional
    public Long removeBbAHBets(BbAHBets bbAHBets) {
        return bbAHBetsDao.removeBbAHBets(bbAHBets);
    }
}
