package com.kmutt.android.fitbitapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Total {

    @Expose
    private Distance distance;
    @Expose
    private Floors floors;
    @Expose
    private Steps steps;

    /**
     * @return The distance
     */
    public Distance getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    /**
     * @return The floors
     */
    public Floors getFloors() {
        return floors;
    }

    /**
     * @param floors The floors
     */
    public void setFloors(Floors floors) {
        this.floors = floors;
    }

    /**
     * @return The steps
     */
    public Steps getSteps() {
        return steps;
    }

    /**
     * @param steps The steps
     */
    public void setSteps(Steps steps) {
        this.steps = steps;
    }

}
