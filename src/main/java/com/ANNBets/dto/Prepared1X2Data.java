package com.ANNBets.dto;

/**
 * Created by siarhei_beliabniou on 27.1.17.
 */
public class Prepared1X2Data {
    private Float Last10HTHM;
    private Float Last10ATAM;
    private Float Last10TvTM;
    private Float Last10TvTMHTHM;
    private Float Last10TvTMATAM;

    public Prepared1X2Data() {
    }

    public Prepared1X2Data(Float last10HTHM, Float last10ATAM, Float last10TvTM, Float last10TvTMHTHM, Float last10TvTMATAM) {
        Last10HTHM = last10HTHM;
        Last10ATAM = last10ATAM;
        Last10TvTM = last10TvTM;
        Last10TvTMHTHM = last10TvTMHTHM;
        Last10TvTMATAM = last10TvTMATAM;
    }

    public Float getLast10HTHM() {
        return Last10HTHM;
    }

    public void setLast10HTHM(Float last10HTHM) {
        Last10HTHM = last10HTHM;
    }

    public Float getLast10ATAM() {
        return Last10ATAM;
    }

    public void setLast10ATAM(Float last10ATAM) {
        Last10ATAM = last10ATAM;
    }

    public Float getLast10TvTM() {
        return Last10TvTM;
    }

    public void setLast10TvTM(Float last10TvTM) {
        Last10TvTM = last10TvTM;
    }

    public Float getLast10TvTMHTHM() {
        return Last10TvTMHTHM;
    }

    public void setLast10TvTMHTHM(Float last10TvTMHTHM) {
        Last10TvTMHTHM = last10TvTMHTHM;
    }

    public Float getLast10TvTMATAM() {
        return Last10TvTMATAM;
    }

    public void setLast10TvTMATAM(Float last10TvTMATAM) {
        Last10TvTMATAM = last10TvTMATAM;
    }
}
