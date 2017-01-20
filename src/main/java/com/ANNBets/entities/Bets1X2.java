package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "1X2_Bets")
public class Bets1X2 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "B365H")
    private Float B365H;

    @Column(name = "B365D")
    private Float B365D;

    @Column(name = "B365A")
    private Float B365A;

    @Column(name = "BSH")
    private Float BSH;

    @Column(name = "BSD")
    private Float BSD;

    @Column(name = "BSA")
    private Float BSA;

    @Column(name = "BWH")
    private Float BWH;

    @Column(name = "BWD")
    private Float BWD;

    @Column(name = "BWA")
    private Float BWA;

    @Column(name = "GBH")
    private Float GBH;

    @Column(name = "GBD")
    private Float GBD;

    @Column(name = "GBA")
    private Float GBA;

    @Column(name = "IWH")
    private Float IWH;

    @Column(name = "IWD")
    private Float IWD;

    @Column(name = "IWA")
    private Float IWA;

    @Column(name = "LBH")
    private Float LBH;

    @Column(name = "LBD")
    private Float LBD;

    @Column(name = "LBA")
    private Float LBA;

    @Column(name = "PSH")
    private Float PSH;

    @Column(name = "PSD")
    private Float PSD;

    @Column(name = "PSA")
    private Float PSA;

    @Column(name = "SOH")
    private Float SOH;

    @Column(name = "SOD")
    private Float SOD;

    @Column(name = "SOA")
    private Float SOA;

    @Column(name = "SBH")
    private Float SBH;

    @Column(name = "SBD")
    private Float SBD;

    @Column(name = "SBA")
    private Float SBA;

    @Column(name = "SJH")
    private Float SJH;

    @Column(name = "SJD")
    private Float SJD;

    @Column(name = "SJA")
    private Float SJA;

    @Column(name = "SYH")
    private Float SYH;

    @Column(name = "SYD")
    private Float SYD;

    @Column(name = "SYA")
    private Float SYA;

    @Column(name = "VCH")
    private Float VCH;

    @Column(name = "VCD")
    private Float VCD;

    @Column(name = "VCA")
    private Float VCA;

    @Column(name = "WHH")
    private Float WHH;

    @Column(name = "WHD")
    private Float WHD;

    @Column(name = "WHA")
    private Float WHA;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getB365H() {
        return B365H;
    }

    public void setB365H(Float b365H) {
        B365H = b365H;
    }

    public Float getB365D() {
        return B365D;
    }

    public void setB365D(Float b365D) {
        B365D = b365D;
    }

    public Float getB365A() {
        return B365A;
    }

    public void setB365A(Float b365A) {
        B365A = b365A;
    }

    public Float getBSH() {
        return BSH;
    }

    public void setBSH(Float BSH) {
        this.BSH = BSH;
    }

    public Float getBSD() {
        return BSD;
    }

    public void setBSD(Float BSD) {
        this.BSD = BSD;
    }

    public Float getBSA() {
        return BSA;
    }

    public void setBSA(Float BSA) {
        this.BSA = BSA;
    }

    public Float getBWH() {
        return BWH;
    }

    public void setBWH(Float BWH) {
        this.BWH = BWH;
    }

    public Float getBWD() {
        return BWD;
    }

    public void setBWD(Float BWD) {
        this.BWD = BWD;
    }

    public Float getBWA() {
        return BWA;
    }

    public void setBWA(Float BWA) {
        this.BWA = BWA;
    }

    public Float getGBH() {
        return GBH;
    }

    public void setGBH(Float GBH) {
        this.GBH = GBH;
    }

    public Float getGBD() {
        return GBD;
    }

    public void setGBD(Float GBD) {
        this.GBD = GBD;
    }

    public Float getGBA() {
        return GBA;
    }

    public void setGBA(Float GBA) {
        this.GBA = GBA;
    }

    public Float getIWH() {
        return IWH;
    }

    public void setIWH(Float IWH) {
        this.IWH = IWH;
    }

    public Float getIWD() {
        return IWD;
    }

    public void setIWD(Float IWD) {
        this.IWD = IWD;
    }

    public Float getIWA() {
        return IWA;
    }

    public void setIWA(Float IWA) {
        this.IWA = IWA;
    }

    public Float getLBH() {
        return LBH;
    }

    public void setLBH(Float LBH) {
        this.LBH = LBH;
    }

    public Float getLBD() {
        return LBD;
    }

    public void setLBD(Float LBD) {
        this.LBD = LBD;
    }

    public Float getLBA() {
        return LBA;
    }

    public void setLBA(Float LBA) {
        this.LBA = LBA;
    }

    public Float getPSH() {
        return PSH;
    }

    public void setPSH(Float PSH) {
        this.PSH = PSH;
    }

    public Float getPSD() {
        return PSD;
    }

    public void setPSD(Float PSD) {
        this.PSD = PSD;
    }

    public Float getPSA() {
        return PSA;
    }

    public void setPSA(Float PSA) {
        this.PSA = PSA;
    }

    public Float getSOH() {
        return SOH;
    }

    public void setSOH(Float SOH) {
        this.SOH = SOH;
    }

    public Float getSOD() {
        return SOD;
    }

    public void setSOD(Float SOD) {
        this.SOD = SOD;
    }

    public Float getSOA() {
        return SOA;
    }

    public void setSOA(Float SOA) {
        this.SOA = SOA;
    }

    public Float getSBH() {
        return SBH;
    }

    public void setSBH(Float SBH) {
        this.SBH = SBH;
    }

    public Float getSBD() {
        return SBD;
    }

    public void setSBD(Float SBD) {
        this.SBD = SBD;
    }

    public Float getSBA() {
        return SBA;
    }

    public void setSBA(Float SBA) {
        this.SBA = SBA;
    }

    public Float getSJH() {
        return SJH;
    }

    public void setSJH(Float SJH) {
        this.SJH = SJH;
    }

    public Float getSJD() {
        return SJD;
    }

    public void setSJD(Float SJD) {
        this.SJD = SJD;
    }

    public Float getSJA() {
        return SJA;
    }

    public void setSJA(Float SJA) {
        this.SJA = SJA;
    }

    public Float getSYH() {
        return SYH;
    }

    public void setSYH(Float SYH) {
        this.SYH = SYH;
    }

    public Float getSYD() {
        return SYD;
    }

    public void setSYD(Float SYD) {
        this.SYD = SYD;
    }

    public Float getSYA() {
        return SYA;
    }

    public void setSYA(Float SYA) {
        this.SYA = SYA;
    }

    public Float getVCH() {
        return VCH;
    }

    public void setVCH(Float VCH) {
        this.VCH = VCH;
    }

    public Float getVCD() {
        return VCD;
    }

    public void setVCD(Float VCD) {
        this.VCD = VCD;
    }

    public Float getVCA() {
        return VCA;
    }

    public void setVCA(Float VCA) {
        this.VCA = VCA;
    }

    public Float getWHH() {
        return WHH;
    }

    public void setWHH(Float WHH) {
        this.WHH = WHH;
    }

    public Float getWHD() {
        return WHD;
    }

    public void setWHD(Float WHD) {
        this.WHD = WHD;
    }

    public Float getWHA() {
        return WHA;
    }

    public void setWHA(Float WHA) {
        this.WHA = WHA;
    }

    public boolean isFilled(){
        return Stream.of(B365H, B365D, B365A, BSH, BSD, BSA, BWH, BWD, BWA, GBH, GBD, GBA, IWH, IWD, IWA, LBH, LBD, LBA,
                PSH, PSD, PSA, SOH, SOD, SOA, SBH, SBD, SBA, SJH, SJD, SJA, SYH, SYD, SYA, VCH, VCD, VCA, WHH, WHD, WHA)
                .anyMatch(Objects::nonNull);
    }
}
