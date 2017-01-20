package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "BbAH_Bets")
public class BbAHBets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BbAHh")
    private Float BbAHh;

    @Column(name = "BbMxAHH")
    private Float BbMxAHH;

    @Column(name = "BbAvAHH")
    private Float BbAvAHH;

    @Column(name = "BbMxAHA")
    private Float BbMxAHA;

    @Column(name = "BbAvAHA")
    private Float BbAvAHA;

    @Column(name = "GBAHH")
    private Float GBAHH;

    @Column(name = "GBAHA")
    private Float GBAHA;

    @Column(name = "GBAH")
    private Float GBAH;

    @Column(name = "LBAHH")
    private Float LBAHH;

    @Column(name = "LBAHA")
    private Float LBAHA;

    @Column(name = "LBAH")
    private Float LBAH;

    @Column(name = "B365AHH")
    private Float B365AHH;

    @Column(name = "B365AHA")
    private Float B365AHA;

    @Column(name = "B365AH")
    private Float B365AH;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBbAHh() {
        return BbAHh;
    }

    public void setBbAHh(Float bbAHh) {
        BbAHh = bbAHh;
    }

    public Float getBbMxAHH() {
        return BbMxAHH;
    }

    public void setBbMxAHH(Float bbMxAHH) {
        BbMxAHH = bbMxAHH;
    }

    public Float getBbAvAHH() {
        return BbAvAHH;
    }

    public void setBbAvAHH(Float bbAvAHH) {
        BbAvAHH = bbAvAHH;
    }

    public Float getBbMxAHA() {
        return BbMxAHA;
    }

    public void setBbMxAHA(Float bbMxAHA) {
        BbMxAHA = bbMxAHA;
    }

    public Float getBbAvAHA() {
        return BbAvAHA;
    }

    public void setBbAvAHA(Float bbAvAHA) {
        BbAvAHA = bbAvAHA;
    }

    public Float getGBAHH() {
        return GBAHH;
    }

    public void setGBAHH(Float GBAHH) {
        this.GBAHH = GBAHH;
    }

    public Float getGBAHA() {
        return GBAHA;
    }

    public void setGBAHA(Float GBAHA) {
        this.GBAHA = GBAHA;
    }

    public Float getGBAH() {
        return GBAH;
    }

    public void setGBAH(Float GBAH) {
        this.GBAH = GBAH;
    }

    public Float getLBAHH() {
        return LBAHH;
    }

    public void setLBAHH(Float LBAHH) {
        this.LBAHH = LBAHH;
    }

    public Float getLBAHA() {
        return LBAHA;
    }

    public void setLBAHA(Float LBAHA) {
        this.LBAHA = LBAHA;
    }

    public Float getLBAH() {
        return LBAH;
    }

    public void setLBAH(Float LBAH) {
        this.LBAH = LBAH;
    }

    public Float getB365AHH() {
        return B365AHH;
    }

    public void setB365AHH(Float b365AHH) {
        B365AHH = b365AHH;
    }

    public Float getB365AHA() {
        return B365AHA;
    }

    public void setB365AHA(Float b365AHA) {
        B365AHA = b365AHA;
    }

    public Float getB365AH() {
        return B365AH;
    }

    public void setB365AH(Float b365AH) {
        B365AH = b365AH;
    }

    public boolean isFilled(){
        return Stream.of(BbAHh, BbMxAHH, BbAvAHH, BbMxAHA, BbAvAHA, GBAHH, GBAHA, GBAH, LBAHH, LBAHA, LBAH, B365AHH, B365AHA, B365AH)
                .anyMatch(Objects::nonNull);
    }
}
