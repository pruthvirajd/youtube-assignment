package com.pruthviraj.youtubeassignment.mapper;

import com.pruthviraj.youtubeassignment.model.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface VideoMapper {

    @Select(" SELECT * FROM tVideo")
    List<Video> getAllVideos();

    @Insert("<script>" +
            "INSERT INTO tVideo (YouTubeVideoID,VideoTitle,VideoDescription,PublishedDate,YoutubeChannelID, ChannelTitle," +
            " DefaultThumbnailURL, MediumThumbnailURL, HighThumbnailURL)" +
            "\nVALUES\n" +
            "<foreach collection='videos' item='video' index='index' separator = ',' open ='' close=''>" +
            "(#{video.youTubeVideoID}, " +
            "#{video.videoTitle}, " +
            "#{video.videoDescription}, " +
            "#{video.publishedDate}, " +
            "#{video.youtubeChannelID}, " +
            "#{video.channelTitle}, " +
            "#{video.defaultThumbnailURL}, " +
            "#{video.mediumThumbnailURL}, " +
            "#{video.highThumbnailURL})" +
            "</foreach>" +
            "</script>")
    void insertListOfVideos(@Param("videos") List<Video> videos);

    @Select("<script>" +
            "SELECT * FROM tVideo " +
            "WHERE (0=1 " +
            "<foreach collection='queries' item='query' index='index' separator = '' open ='' close=''>" +
            " OR VideoTitle LIKE '%${queries}%'" +
            "</foreach>)" +
            "OR (0=1 " +
            "<foreach collection='queries' item='query' index='index'>" +
            " OR VideoDescription LIKE '%${queries}%'" +
            "</foreach>)" +
            "</script>")
//    @Select("<script>" +
//            "SELECT * FROM tVideo " +
//            "WHERE VideoTitle LIKE '%${param1}%' OR VideoDescription LIKE '%${param1}%'" +
//            "</script>")
    List<Video> searchForQuery(@Param("queries") List<String> queries);
}
