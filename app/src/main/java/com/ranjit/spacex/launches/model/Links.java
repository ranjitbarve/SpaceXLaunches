package com.ranjit.spacex.launches.model;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Links {
    @SerializedName("mission_patch")
    public String missionPatch;

    @SerializedName("mission_patch_small")
    public String missionPatchSmall;

    @SerializedName("reddit_campaign")
    public String redditCampaign;

    @SerializedName("reddit_launch")
    public String redditLaunch;

    @SerializedName("reddit_recovery")
    public Object redditRecovery;

    @SerializedName("reddit_media")
    public String redditMedia;

    @SerializedName("presskit")
    public String presskit;

    @SerializedName("article_link")
    public String articleLink;

    @SerializedName("wikipedia")
    public String wikipedia;

    @SerializedName("video_link")
    public String videoLink;

    @SerializedName("youtube_id")
    public String youtubeId;

    @SerializedName("flickr_images")
    public ArrayList<String> flickrImages;

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getRedditCampaign() {
        return redditCampaign;
    }

    public void setRedditCampaign(String redditCampaign) {
        this.redditCampaign = redditCampaign;
    }

    public String getRedditLaunch() {
        return redditLaunch;
    }

    public void setRedditLaunch(String redditLaunch) {
        this.redditLaunch = redditLaunch;
    }

    public Object getRedditRecovery() {
        return redditRecovery;
    }

    public void setRedditRecovery(Object redditRecovery) {
        this.redditRecovery = redditRecovery;
    }

    public String getRedditMedia() {
        return redditMedia;
    }

    public void setRedditMedia(String redditMedia) {
        this.redditMedia = redditMedia;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public ArrayList<String> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(ArrayList<String> flickrImages) {
        this.flickrImages = flickrImages;
    }
}
