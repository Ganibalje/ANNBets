package com.ANNBets.service;

import com.ANNBets.entities.Bets1X2;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface Bets1X2Service {
    Long addBets1X2(Bets1X2 bets1X2);
    Long updateBets1X2(Bets1X2 bets1X2);
    List<Bets1X2> listBets1X2();
    Bets1X2 getBets1X2ById(Long id);
    Long removeBets1X2(Bets1X2 bets1X2);
}
