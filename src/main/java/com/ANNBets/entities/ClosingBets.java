package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "Closing_Bets")
public class ClosingBets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PSCH")
    private Float PSCH;

    @Column(name = "PSCD")
    private Float PSCD;

    @Column(name = "PSCA")
    private Float PSCA;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPSCH() {
        return PSCH;
    }

    public void setPSCH(Float PSCH) {
        this.PSCH = PSCH;
    }

    public Float getPSCD() {
        return PSCD;
    }

    public void setPSCD(Float PSCD) {
        this.PSCD = PSCD;
    }

    public Float getPSCA() {
        return PSCA;
    }

    public void setPSCA(Float PSCA) {
        this.PSCA = PSCA;
    }
}
