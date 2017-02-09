package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by ganibal on 16.1.17.
 */
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public Team() {
    }

    public Team(String name, League league) {
        this.name = name;
        this.league = league;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
