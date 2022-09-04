package com.pruthviraj.youtubeassignment.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tVideoInfo")
public class Video {

    @Id
    @GeneratedValue
    private int videoID;

    private String youtubeVideoID;

    @Column(name="VideoTitle", nullable = false)
    private String videoTitle;

    @Column(name="VideoDescription", nullable = false, length = 500)
    private String videoDescription;

    private Date publishedDate;

    private String youtubeChannelID;

    private String channelTitle;

    private String defaultThumbnailURL;

    private String mediumThumbnailURL;

    private String highThumbnailURL;

    public Video(){}

    public Video(String youtubeVideoID, String videoTitle, String videoDescription, Date publishedDate, String youtubeChannelID, String channelTitle, String defaultThumbnailURL, String mediumThumbnailURL, String highThumbnailURL) {
        this.youtubeVideoID = youtubeVideoID;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.publishedDate = publishedDate;
        this.youtubeChannelID = youtubeChannelID;
        this.channelTitle = channelTitle;
        this.defaultThumbnailURL = defaultThumbnailURL;
        this.mediumThumbnailURL = mediumThumbnailURL;
        this.highThumbnailURL = highThumbnailURL;
    }


    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getyoutubeVideoID() {
        return youtubeVideoID;
    }

    public void setyoutubeVideoID(String youtubeVideoID) {
        this.youtubeVideoID = youtubeVideoID;
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
