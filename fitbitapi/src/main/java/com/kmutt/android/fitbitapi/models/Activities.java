package com.kmutt.android.fitbitapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Activities {

    @Expose
    private Best best;
    @Expose
    private Lifetime lifetime;

    /**
     * @return The best
     */
    public Best getBest() {
        return best;
    }

    /**
     * @param best The best
     */
    public void setBest(Best best) {
        this.best = best;
    }

    /**
     * @return The lifetime
     */
    public Lifetime getLifetime() {
        return lifetime;
    }

    /**
     * @param lifetime The lifetime
     */
    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
    }

}
