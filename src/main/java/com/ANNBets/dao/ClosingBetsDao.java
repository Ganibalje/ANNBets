package com.ANNBets.dao;

import com.ANNBets.entities.ClosingBets;
import com.ANNBets.entities.League;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 17.1.17.
 */
public interface ClosingBetsDao {
    Long addClosingBets(ClosingBets closingBets);
    Long updateClosingBets(ClosingBets closingBets);
    List<ClosingBets> listClosingBets();
    ClosingBets getClosingBetsById(Long id);
    Long removeClosingBets(ClosingBets closingBets);
}
