package com.ranjit.spacex.launches.model.rocket;


import com.google.gson.annotations.SerializedName;

public class Rocket {
    @SerializedName("rocket_id")
    public String rocketId;

    @SerializedName("rocket_name")
    public String rocketName;

    @SerializedName("rocket_type")
    public String rocketType;

    @SerializedName("first_stage")
    public FirstStage firstStage;

    @SerializedName("second_stage")
    public SecondStage secondStage;


    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }
}
