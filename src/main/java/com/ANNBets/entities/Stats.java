package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by ganibal on 16.1.17.
 */
@Entity
@Table(name = "Stats")
public class Stats {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usual_stats_id")
    private UsualStats usualStats;

    @ManyToOne
    @JoinColumn(name = "additional_stats_id")
    private AdditionalStats additionalStats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsualStats getUsualStats() {
        return usualStats;
    }

    public void setUsualStats(UsualStats usualStats) {
        this.usualStats = usualStats;
    }

    public AdditionalStats getAdditionalStats() {
        return additionalStats;
    }

    public void setAdditionalStats(AdditionalStats additionalStats) {
        this.additionalStats = additionalStats;
    }
}
