package com.ANNBets.entities;


import javax.persistence.*;

/**
 * Created by siarhei_beliabniou on 16.1.17.
 */
@Entity
@Table(name = "Referee")
public class Referee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Referee() {
    }

    public Referee(String name) {
        this.name = name;
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
}
