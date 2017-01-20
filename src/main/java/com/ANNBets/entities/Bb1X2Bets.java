package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "Bb1X2_Bets")
public class Bb1X2Bets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BbMxH")
    private Float BbMxH;

    @Column(name = "BbAvH")
    private Float BbAvH;

    @Column(name = "BbMxD")
    private Float BbMxD;

    @Column(name = "BbAvD")
    private Float BbAvD;

    @Column(name = "BbMxA")
    private Float BbMxA;

    @Column(name = "BbAvA")
    private Float BbAvA;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBbMxH() {
        return BbMxH;
    }

    public void setBbMxH(Float bbMxH) {
        BbMxH = bbMxH;
    }

    public Float getBbAvH() {
        return BbAvH;
    }

    public void setBbAvH(Float bbAvH) {
        BbAvH = bbAvH;
    }

    public Float getBbMxD() {
        return BbMxD;
    }

    public void setBbMxD(Float bbMxD) {
        BbMxD = bbMxD;
    }

    public Float getBbAvD() {
        return BbAvD;
    }

    public void setBbAvD(Float bbAvD) {
        BbAvD = bbAvD;
    }

    public Float getBbMxA() {
        return BbMxA;
    }

    public void setBbMxA(Float bbMxA) {
        BbMxA = bbMxA;
    }

    public Float getBbAvA() {
        return BbAvA;
    }

    public void setBbAvA(Float bbAvA) {
        BbAvA = bbAvA;
    }

    public boolean isFilled(){
        return Stream.of(BbMxH, BbAvH, BbMxD, BbAvD, BbMxA, BbAvA)
                .anyMatch(Objects::nonNull);
    }
}
