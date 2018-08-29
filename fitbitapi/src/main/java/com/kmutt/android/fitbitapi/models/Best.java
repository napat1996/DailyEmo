package com.kmutt.android.fitbitapi.models;

ublic class Best {

    @SerializedName("total")
    @Expose
    private Total total;
    @SerializedName("tracker")
    @Expose
    private Tracker tracker;

    /**
     * @return The total
     */
    public Total getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(Total total) {
        this.total = total;
    }

    /**
     * @return The tracker
     */
    public Tracker getTracker() {
        return tracker;
    }

    /**
     * @param tracker The tracker
     */
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

}
