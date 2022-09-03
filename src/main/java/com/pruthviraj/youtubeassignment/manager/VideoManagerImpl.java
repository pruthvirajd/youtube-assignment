package com.pruthviraj.youtubeassignment.manager;

import com.pruthviraj.youtubeassignment.mapper.VideoMapper;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Repository
@Service
public class VideoManagerImpl implements VideoManager {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAll() {
        return videoMapper.getAllVideos();
    }

    @Override
    public void insertVideos(List<Video> videos){
        videoMapper.insertListOfVideos(videos);
    }

    @Override
    public List<Video> searchForQuery(List<String> query) {

        List<String> queries = new ArrayList<>();
        queries.addAll(query);

        return videoMapper.searchForQuery(queries);
    }

    public void insertDummyVideos(){

        List<Video> videos = new ArrayList<>();

        for(int i=1; i<101; i++){
            Video video = new Video();
            video.setPublishedDate(new Date(2022,9,3));
            video.setHighThumbnailURL("HighThumbnailURL"+i);
            video.setMediumThumbnailURL("MediumThumbnailURL"+i);
            video.setDefaultThumbnailURL("DefaultThumbnailURL"+i);
            video.setYouTubeVideoID("YouTubeVideoID"+i);
            video.setChannelTitle("ChannelTitle"+i);
            video.setVideoTitle("Video Title "+i);
            video.setVideoDescription("Video Description "+i);
            video.setYoutubeChannelID("YoutubeChannelID"+i);
            videos.add(video);
        }
        videoMapper.insertListOfVideos(videos);
    }
}
