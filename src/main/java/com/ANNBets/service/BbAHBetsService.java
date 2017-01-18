package com.ANNBets.service;

import com.ANNBets.entities.BbAHBets;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface BbAHBetsService {
    Long addBbAHBets(BbAHBets bbAHBets);
    Long updateBbAHBets(BbAHBets bbAHBets);
    List<BbAHBets> listBbAHBets();
    BbAHBets getBbAHBetsById(Long id);
    Long removeBbAHBets(BbAHBets bbAHBets);
}
