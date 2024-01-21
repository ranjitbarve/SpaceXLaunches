package com.ranjit.spacex.launches.model.rocket;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrbitParams{
    @SerializedName("reference_system")
    public String referenceSystem;

    @SerializedName("semi_major_axis_km")
    public double semiMajorAxisKm;

    @SerializedName("eccentricity")
    public double eccentricity;

    @SerializedName("periapsis_km")
    public double periapsisKm;

    @SerializedName("apoapsis_km")
    public double apoapsisKm;

    @SerializedName("inclination_deg")
    public double inclinationDeg;

    @SerializedName("period_min")
    public double periodMin;

    @SerializedName("lifespan_years")
    public double lifespanYears;

    @SerializedName("epoch")
    public Date epoch;

    @SerializedName("mean_motion")
    public double meanMotion;

    @SerializedName("raan")
    public double raan;

    @SerializedName("arg_of_pericenter")
    public double argOfPericenter;

    @SerializedName("mean_anomaly")
    public double meanAnomaly;

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }


    public double getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(double semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(double periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public double getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(double apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public double getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(double inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public double getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(double periodMin) {
        this.periodMin = periodMin;
    }

    public double getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(double lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public Date getEpoch() {
        return epoch;
    }

    public void setEpoch(Date epoch) {
        this.epoch = epoch;
    }

    public double getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public double getRaan() {
        return raan;
    }

    public void setRaan(double raan) {
        this.raan = raan;
    }

    public double getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(double argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(double meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }
}
