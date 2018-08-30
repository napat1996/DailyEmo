package com.kmutt.android.fitbitapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {

    @Expose
    private String battery;
    @Expose
    private String deviceVersion;
    @Expose
    private String id;
    @Expose
    private String lastSyncTime;
    @Expose
    private String type;

    /**
     * @return The battery
     */
    public String getBattery() {
        return battery;
    }

    /**
     * @param battery The battery
     */
    public void setBattery(String battery) {
        this.battery = battery;
    }

    /**
     * @return The deviceVersion
     */
    public String getDeviceVersion() {
        return deviceVersion;
    }

    /**
     * @param deviceVersion The deviceVersion
     */
    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The lastSyncTime
     */
    public String getLastSyncTime() {
        return lastSyncTime;
    }

    /**
     * @param lastSyncTime The lastSyncTime
     */
    public void setLastSyncTime(String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
