package com.runverse.API.System.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "metrics")
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double hydration;
    private Double fatigue;
    private Double posture;
    private Double heartRate;
    private Double steps;
    private Double sleepHours;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // Constructors
    public Metrics() {}

    public Metrics(User user) {
        this.user = user;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHydration() {
        return hydration;
    }

    public void setHydration(Double hydration) {
        this.hydration = hydration;
    }

    public Double getFatigue() {
        return fatigue;
    }

    public void setFatigue(Double fatigue) {
        this.fatigue = fatigue;
    }

    public Double getPosture() {
        return posture;
    }

    public void setPosture(Double posture) {
        this.posture = posture;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public Double getSteps() {
        return steps;
    }

    public void setSteps(Double steps) {
        this.steps = steps;
    }

    public Double getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(Double sleepHours) {
        this.sleepHours = sleepHours;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
