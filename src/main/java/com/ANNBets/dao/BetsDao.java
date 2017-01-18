package com.ANNBets.dao;

import com.ANNBets.entities.Bets;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface BetsDao {
    Long addBets(Bets bets);
    Long updateBets(Bets bets);
    List<Bets> listBets();
    Bets getBetsById(Long id);
    Long removeBets(Bets bets);
}
