package com.ANNBets.service;

import com.ANNBets.dao.RefereeDao;
import com.ANNBets.entities.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeDao refereeDao;

    @Override
    @Transactional
    public Long addReferee(Referee referee) {
        return refereeDao.addReferee(referee);
    }

    @Override
    @Transactional
    public Long updateReferee(Referee referee) {
        return refereeDao.updateReferee(referee);
    }

    @Override
    @Transactional
    public List<Referee> listReferees() {
        return refereeDao.listReferees();
    }

    @Override
    @Transactional
    public Referee getRefereeById(Long id) {
        return refereeDao.getRefereeById(id);
    }

    @Override
    @Transactional
    public Long removeReferee(Referee referee) {
        return refereeDao.removeReferee(referee);
    }

    @Override
    @Transactional
    public Boolean isExistByName(String name) {
        return refereeDao.isExistByName(name);
    }

    @Override
    @Transactional
    public Referee getRefereeByName(String name) {
        return refereeDao.getRefereeByName(name);
    }
}
