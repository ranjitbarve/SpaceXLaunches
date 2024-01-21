package com.ranjit.spacex.launches.model;

import com.google.gson.annotations.SerializedName;

public class LaunchSite {
    @SerializedName("site_id")
    public String siteId;

    @SerializedName("site_name")
    public String siteName;

    @SerializedName("site_name_long")
    public String siteNameLong;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }
}
