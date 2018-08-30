package com.kmutt.android.fitbitapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DailyActivitySummary {

    @Expose
    private List<Object> activities = new ArrayList<Object>();
    @Expose
    private Goals goals;
    @Expose
    private Summary summary;

    /**
     * @return The activities
     */
    public List<Object> getActivities() {
        return activities;
    }

    /**
     * @param activities The activities
     */
    public void setActivities(List<Object> activities) {
        this.activities = activities;
    }

    /**
     * @return The goals
     */
    public Goals getGoals() {
        return goals;
    }

    /**
     * @param goals The goals
     */
    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    /**
     * @return The summary
     */
    public Summary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

}
