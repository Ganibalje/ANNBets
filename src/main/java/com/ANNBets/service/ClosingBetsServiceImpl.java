package com.ANNBets.service;

import com.ANNBets.dao.ClosingBetsDao;
import com.ANNBets.entities.ClosingBets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Service
public class ClosingBetsServiceImpl implements ClosingBetsService {

    @Autowired
    private ClosingBetsDao closingBetsDao;

    @Override
    @Transactional
    public Long addClosingBets(ClosingBets closingBets) {
        return closingBetsDao.addClosingBets(closingBets);
    }

    @Override
    @Transactional
    public Long updateClosingBets(ClosingBets closingBets) {
        return closingBetsDao.updateClosingBets(closingBets);
    }

    @Override
    @Transactional
    public List<ClosingBets> listClosingBets() {
        return closingBetsDao.listClosingBets();
    }

    @Override
    @Transactional
    public ClosingBets getClosingBetsById(Long id) {
        return closingBetsDao.getClosingBetsById(id);
    }

    @Override
    @Transactional
    public Long removeClosingBets(ClosingBets closingBets) {
        return closingBetsDao.removeClosingBets(closingBets);
    }
}
