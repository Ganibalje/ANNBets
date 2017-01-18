package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "Bets")
public class Bets {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "1X2_Bets_id")
    private Bets1X2 bets1X2;

    @ManyToOne
    @JoinColumn(name = "Bb1X2_Bets_id")
    private Bb1X2Bets bb1X2Bets;

    @ManyToOne
    @JoinColumn(name = "BbOU_Bets_id")
    private BbOUBets bbOUBets;

    @ManyToOne
    @JoinColumn(name = "BbAH_Bets_id")
    private BbAHBets bbAHBets;

    @ManyToOne
    @JoinColumn(name = "Closing_Bets_id")
    private ClosingBets closingBets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bets1X2 getBets1X2() {
        return bets1X2;
    }

    public void setBets1X2(Bets1X2 bets1X2) {
        this.bets1X2 = bets1X2;
    }

    public Bb1X2Bets getBb1X2Bets() {
        return bb1X2Bets;
    }

    public void setBb1X2Bets(Bb1X2Bets bb1X2Bets) {
        this.bb1X2Bets = bb1X2Bets;
    }

    public BbOUBets getBbOUBets() {
        return bbOUBets;
    }

    public void setBbOUBets(BbOUBets bbOUBets) {
        this.bbOUBets = bbOUBets;
    }

    public BbAHBets getBbAHBets() {
        return bbAHBets;
    }

    public void setBbAHBets(BbAHBets bbAHBets) {
        this.bbAHBets = bbAHBets;
    }

    public ClosingBets getClosingBets() {
        return closingBets;
    }

    public void setClosingBets(ClosingBets closingBets) {
        this.closingBets = closingBets;
    }
}
