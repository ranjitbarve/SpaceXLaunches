package com.ranjit.spacex.launches.model.rocket;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FirstStage {
    @SerializedName("cores")
    public ArrayList<Core> cores;


    public ArrayList<Core> getCores() {
        return cores;
    }

    public void setCores(ArrayList<Core> cores) {
        this.cores = cores;
    }
}
