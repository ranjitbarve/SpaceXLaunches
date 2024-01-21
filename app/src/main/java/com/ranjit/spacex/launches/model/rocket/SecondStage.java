package com.ranjit.spacex.launches.model.rocket;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SecondStage {
    @SerializedName("block")
    public int block;

    @SerializedName("payloads")
    public ArrayList<Payload> payloads;

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public ArrayList<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(ArrayList<Payload> payloads) {
        this.payloads = payloads;
    }
}
