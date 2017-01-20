package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "BbOU_Bets")
public class BbOUBets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BbMx_more_25")
    private Float BbMx_more_25;

    @Column(name = "BbAv_more_25")
    private Float BbAv_more_25;

    @Column(name = "BbMx_less_25")
    private Float BbMx_less_25;

    @Column(name = "BbAv_less_25")
    private Float BbAv_less_25;

    @Column(name = "GB_more_25")
    private Float GB_more_25;

    @Column(name = "GB_less_25")
    private Float GB_less_25;

    @Column(name = "B365_more_25")
    private Float B365_more_25;

    @Column(name = "B365_less_25")
    private Float B365_less_25;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBbMx_more_25() {
        return BbMx_more_25;
    }

    public Float getBbAv_more_25() {
        return BbAv_more_25;
    }

    public void setBbAv_more_25(Float bbAv_more_25) {
        BbAv_more_25 = bbAv_more_25;
    }

    public Float getBbMx_less_25() {
        return BbMx_less_25;
    }

    public void setBbMx_less_25(Float bbMx_less_25) {
        BbMx_less_25 = bbMx_less_25;
    }

    public void setBbMx_more_25(Float bbMx_more_25) {
        BbMx_more_25 = bbMx_more_25;
    }

    public Float getBbAv_less_25() {
        return BbAv_less_25;
    }

    public void setBbAv_less_25(Float bbAv_less_25) {
        BbAv_less_25 = bbAv_less_25;
    }

    public Float getGB_more_25() {
        return GB_more_25;
    }

    public void setGB_more_25(Float GB_more_25) {
        this.GB_more_25 = GB_more_25;
    }

    public Float getGB_less_25() {
        return GB_less_25;
    }

    public void setGB_less_25(Float GB_less_25) {
        this.GB_less_25 = GB_less_25;
    }

    public Float getB365_more_25() {
        return B365_more_25;
    }

    public void setB365_more_25(Float b365_more_25) {
        B365_more_25 = b365_more_25;
    }

    public Float getB365_less_25() {
        return B365_less_25;
    }

    public void setB365_less_25(Float b365_less_25) {
        B365_less_25 = b365_less_25;
    }

    public boolean isFilled(){
        return Stream.of(BbMx_more_25, BbAv_more_25, BbMx_less_25, BbAv_less_25, GB_more_25, GB_less_25, B365_more_25, B365_less_25)
                .anyMatch(Objects::nonNull);
    }
}
