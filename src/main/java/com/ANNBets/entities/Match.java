package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by siarhei_beliabniou on 18.1.17.
 */
@Entity
@Table(name = "Match")
public class Match {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_match")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "Stats_id")
    private Stats stats;

    @ManyToOne
    @JoinColumn(name = "Bets_id")
    private Bets bets;

    @ManyToOne
    @JoinColumn(name = "Referee_id")
    private Referee referee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Bets getBets() {
        return bets;
    }

    public void setBets(Bets bets) {
        this.bets = bets;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
