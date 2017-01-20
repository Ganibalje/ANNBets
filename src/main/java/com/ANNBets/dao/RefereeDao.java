package com.ANNBets.dao;

import com.ANNBets.entities.Referee;

import java.util.List;


/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
public interface RefereeDao {
    Long addReferee(Referee referee);
    Long updateReferee(Referee referee);
    List<Referee> listReferees();
    Referee getRefereeById(Long id);
    Long removeReferee(Referee referee);
    Boolean isExistByName(String name);
    Referee getRefereeByName(String name);
}
