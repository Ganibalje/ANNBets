package com.ANNBets.service;

import com.ANNBets.dao.BbOUBetsDao;
import com.ANNBets.entities.BbOUBets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class BbOUBetsServiceImpl implements BbOUBetsService {

    @Autowired
    private BbOUBetsDao bbOUBetsDao;

    @Override
    @Transactional
    public Long addBbOUBets(BbOUBets bbOUBets) {
        return bbOUBetsDao.addBbOUBets(bbOUBets);
    }

    @Override
    @Transactional
    public Long updateBbOUBets(BbOUBets bbOUBets) {
        return bbOUBetsDao.updateBbOUBets(bbOUBets);
    }

    @Override
    @Transactional
    public List<BbOUBets> listBbOUBets() {
        return bbOUBetsDao.listBbOUBets();
    }

    @Override
    @Transactional
    public BbOUBets getBbOUBetsById(Long id) {
        return bbOUBetsDao.getBbOUBetsById(id);
    }

    @Override
    @Transactional
    public Long removeBbOUBets(BbOUBets bbOUBets) {
        return bbOUBetsDao.removeBbOUBets(bbOUBets);
    }
}
