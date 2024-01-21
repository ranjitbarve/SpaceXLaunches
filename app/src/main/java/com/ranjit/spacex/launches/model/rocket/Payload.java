package com.ranjit.spacex.launches.model.rocket;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Payload {
    @SerializedName("payload_id")
    public String payloadId;

    @SerializedName("norad_id")
    public ArrayList<Integer> noradId;

    @SerializedName("reused")
    public boolean reused;

    @SerializedName("customers")
    public ArrayList<String> customers;

    @SerializedName("nationality")
    public String nationality;

    @SerializedName("manufacturer")
    public String manufacturer;

    @SerializedName("payload_type")
    public String payloadType;

    @SerializedName("payload_mass_kg")
    public double payloadMassKg;

    @SerializedName("payload_mass_lbs")
    public double payloadMassLbs;

    @SerializedName("orbit")
    public String orbit;

    @SerializedName("orbit_params")
    public OrbitParams orbitParams;


    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public ArrayList<Integer> getNoradId() {
        return noradId;
    }

    public void setNoradId(ArrayList<Integer> noradId) {
        this.noradId = noradId;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public ArrayList<String> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public double getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(double payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(double payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }
}
