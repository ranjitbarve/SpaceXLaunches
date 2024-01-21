package com.ranjit.spacex.launches.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.ranjit.spacex.launches.model.rocket.Rocket;

@Entity(tableName = "launch")
public class Launches {


    @PrimaryKey
    @SerializedName("flight_number")
    @ColumnInfo(name = "flight_number")
    private int flightNumber;

    @SerializedName("mission_name")
    @ColumnInfo(name = "mission_name")
    private String missionName;

    @SerializedName("launch_date_local")
    @ColumnInfo(name = "launch_date_local")
    private String launchDateLocal;

    @SerializedName("upcoming")
    @ColumnInfo(name = "upcoming", defaultValue = "false")
    private boolean upcoming;

    @SerializedName("launch_success")
    @ColumnInfo(name = "launch_success", defaultValue = "false")
    private boolean launchSuccess;

    @SerializedName("details")
    @ColumnInfo(name = "details")
    private String details;

    @SerializedName("launch_window")
    @ColumnInfo(name = "launch_window")
    private Long launchWindow;


    @SerializedName("isFavorite")
    @ColumnInfo(name = "is_favorite", defaultValue = "false")
    private boolean isFavorite;

    @Ignore
    @SerializedName("rocket")
    private Rocket rocket;

    @Ignore
    @SerializedName("links")
    private Links links;

    @ColumnInfo(name = "rocket_name")
    private String rocketName;

    @ColumnInfo(name = "mission_patch_small")
    private String missionPatchSmall;


    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public boolean isLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Long launchWindow) {
        this.launchWindow = launchWindow;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }
}
