package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by ganibal on 16.1.17.
 */
@Entity
@Table(name = "Additional_stats")
public class AdditionalStats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HSh")
    private Integer HS;

    @Column(name = "ASh")
    private Integer AS;

    @Column(name = "HST")
    private Integer HST;

    @Column(name = "AST")
    private Integer AST;

    @Column(name = "HHW")
    private Integer HHW;

    @Column(name = "AHW")
    private Integer AHW;

    @Column(name = "HC")
    private Integer HC;

    @Column(name = "AC")
    private Integer AC;

    @Column(name = "HF")
    private Integer HF;

    @Column(name = "AF")
    private Integer AF;

    @Column(name = "HO")
    private Integer HO;

    @Column(name = "AO")
    private Integer AO;

    @Column(name = "HY")
    private Integer HY;

    @Column(name = "AY")
    private Integer AY;

    @Column(name = "HR")
    private Integer HR;

    @Column(name = "AR")
    private Integer AR;

    @Column(name = "HBP")
    private  Integer HBP;

    @Column(name = "ABP")
    private Integer ABP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHS() {
        return HS;
    }

    public void setHS(Integer HS) {
        this.HS = HS;
    }

    public Integer getAS() {
        return AS;
    }

    public void setAS(Integer AS) {
        this.AS = AS;
    }

    public Integer getHST() {
        return HST;
    }

    public void setHST(Integer HST) {
        this.HST = HST;
    }

    public Integer getAST() {
        return AST;
    }

    public void setAST(Integer AST) {
        this.AST = AST;
    }

    public Integer getHHW() {
        return HHW;
    }

    public void setHHW(Integer HHW) {
        this.HHW = HHW;
    }

    public Integer getAHW() {
        return AHW;
    }

    public void setAHW(Integer AHW) {
        this.AHW = AHW;
    }

    public Integer getHC() {
        return HC;
    }

    public void setHC(Integer HC) {
        this.HC = HC;
    }

    public Integer getAC() {
        return AC;
    }

    public void setAC(Integer AC) {
        this.AC = AC;
    }

    public Integer getHF() {
        return HF;
    }

    public void setHF(Integer HF) {
        this.HF = HF;
    }

    public Integer getAF() {
        return AF;
    }

    public void setAF(Integer AF) {
        this.AF = AF;
    }

    public Integer getHO() {
        return HO;
    }

    public void setHO(Integer HO) {
        this.HO = HO;
    }

    public Integer getAO() {
        return AO;
    }

    public void setAO(Integer AO) {
        this.AO = AO;
    }

    public Integer getHY() {
        return HY;
    }

    public void setHY(Integer HY) {
        this.HY = HY;
    }

    public Integer getAY() {
        return AY;
    }

    public void setAY(Integer AY) {
        this.AY = AY;
    }

    public Integer getHR() {
        return HR;
    }

    public void setHR(Integer HR) {
        this.HR = HR;
    }

    public Integer getAR() {
        return AR;
    }

    public void setAR(Integer AR) {
        this.AR = AR;
    }

    public Integer getHBP() {
        return HBP;
    }

    public void setHBP(Integer HBP) {
        this.HBP = HBP;
    }

    public Integer getABP() {
        return ABP;
    }

    public void setABP(Integer ABP) {
        this.ABP = ABP;
    }
}
