package com.ANNBets.service;

import com.ANNBets.entities.ClosingBets;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
public interface ClosingBetsService {
    Long addClosingBets(ClosingBets closingBets);
    Long updateClosingBets(ClosingBets closingBets);
    List<ClosingBets> listClosingBets();
    ClosingBets getClosingBetsById(Long id);
    Long removeClosingBets(ClosingBets closingBets);
}
