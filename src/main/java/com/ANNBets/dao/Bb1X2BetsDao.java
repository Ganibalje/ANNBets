package com.ANNBets.dao;

import com.ANNBets.entities.AdditionalStats;
import com.ANNBets.entities.Bb1X2Bets;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface Bb1X2BetsDao {
    Long addBb1X2Bets(Bb1X2Bets bb1X2Bets);
    Long updateBb1X2Bets(Bb1X2Bets bb1X2Bets);
    List<Bb1X2Bets> listBb1X2Bets();
    Bb1X2Bets getBb1X2BetsById(Long id);
    Long removeBb1X2Bets(Bb1X2Bets bb1X2Bets);
}
