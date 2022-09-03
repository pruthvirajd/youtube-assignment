package com.pruthviraj.youtubeassignment.model;

import java.util.Date;

public class Video {
    private int videoID;

    private String youTubeVideoID;

    private String videoTitle;

    private String videoDescription;

    private Date publishedDate;

    private String youtubeChannelID;

    private String channelTitle;

    private String defaultThumbnailURL;

    private String mediumThumbnailURL;

    private String highThumbnailURL;

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getYouTubeVideoID() {
        return youTubeVideoID;
    }

    public void setYouTubeVideoID(String youTubeVideoID) {
        this.youTubeVideoID = youTubeVideoID;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getYoutubeChannelID() {
        return youtubeChannelID;
    }

    public void setYoutubeChannelID(String youtubeChannelID) {
        this.youtubeChannelID = youtubeChannelID;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getDefaultThumbnailURL() {
        return defaultThumbnailURL;
    }

    public void setDefaultThumbnailURL(String defaultThumbnailURL) {
        this.defaultThumbnailURL = defaultThumbnailURL;
    }

    public String getMediumThumbnailURL() {
        return mediumThumbnailURL;
    }

    public void setMediumThumbnailURL(String mediumThumbnailURL) {
        this.mediumThumbnailURL = mediumThumbnailURL;
    }

    public String getHighThumbnailURL() {
        return highThumbnailURL;
    }

    public void setHighThumbnailURL(String highThumbnailURL) {
        this.highThumbnailURL = highThumbnailURL;
    }
}
