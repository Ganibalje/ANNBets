package com.ANNBets.service;

import com.ANNBets.entities.BbOUBets;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface BbOUBetsService {
    Long addBbOUBets(BbOUBets bbOUBets);
    Long updateBbOUBets(BbOUBets bbOUBets);
    List<BbOUBets> listBbOUBets();
    BbOUBets getBbOUBetsById(Long id);
    Long removeBbOUBets(BbOUBets bbOUBets);
}
