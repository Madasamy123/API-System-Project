package com.runverse.API.System.Project.DTO;

public class MetricsDto {
    private Double hydration;
    private Double fatigue;
    private Double posture;
    private Double heartRate;
    private Double steps;
    private Double sleepHours;

    // getters and setters

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
}

