package com.ANNBets.Entities;

import javax.persistence.*;

/**
 * Created by ganibal on 16.1.17.
 */
@Entity
@Table(name = "Usual_stats")
public class UsualStats {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FTHG")
    private Integer FTHG;

    @Column(name = "FTAG")
    private Integer FTAG;

    @Column(name = "FTR")
    private String FTR;

    @Column(name = "HTHG")
    private Integer HTHG;

    @Column(name = "HTAG")
    private Integer HTAG;

    @Column(name = "HTR")
    private String HTR;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFTHG() {
        return FTHG;
    }

    public void setFTHG(Integer FTHG) {
        this.FTHG = FTHG;
    }

    public Integer getFTAG() {
        return FTAG;
    }

    public void setFTAG(Integer FTAG) {
        this.FTAG = FTAG;
    }

    public String getFTR() {
        return FTR;
    }

    public void setFTR(String FTR) {
        this.FTR = FTR;
    }

    public Integer getHTHG() {
        return HTHG;
    }

    public void setHTHG(Integer HTHG) {
        this.HTHG = HTHG;
    }

    public Integer getHTAG() {
        return HTAG;
    }

    public void setHTAG(Integer HTAG) {
        this.HTAG = HTAG;
    }

    public String getHTR() {
        return HTR;
    }

    public void setHTR(String HTR) {
        this.HTR = HTR;
    }
}
