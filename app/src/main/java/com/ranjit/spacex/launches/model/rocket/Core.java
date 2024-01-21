package com.ranjit.spacex.launches.model.rocket;

import com.google.gson.annotations.SerializedName;

public class Core {
    @SerializedName("core_serial")
    public String coreSerial;

    @SerializedName("flight")
    public int flight;
    @SerializedName("block")
    public int block;

    @SerializedName("gridfins")
    public boolean gridfins;

    @SerializedName("legs")
    public boolean legs;

    @SerializedName("reused")
    public boolean reused;

    @SerializedName("landing_intent")
    public boolean landingIntent;


    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }


    public boolean isGridfins() {
        return gridfins;
    }

    public void setGridfins(boolean gridfins) {
        this.gridfins = gridfins;
    }

    public boolean isLegs() {
        return legs;
    }

    public void setLegs(boolean legs) {
        this.legs = legs;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public boolean isLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(boolean landingIntent) {
        this.landingIntent = landingIntent;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
