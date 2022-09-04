package com.pruthviraj.youtubeassignment.manager;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.mapper.VideoMapper;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VideoManagerImpl implements VideoManager {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAll() {
        System.out.println("Getting All Videos");
        return videoMapper.getAllVideos();
    }

    @Override
    public void insertVideos(List<Video> videos){
        System.out.println("Inserting " +videos.size() + "videos");
        if(videos.size()>0)
            videoMapper.insertListOfVideos(videos);
    }

    @Override
    public List<Video> searchForQuery(String query) {
        System.out.println("Search for following query: "+query);
        //TODO: Add fuzzy Search
        List<String> queries = new ArrayList<>();
        queries.add(query);

        return videoMapper.searchForQuery(queries);
    }

    @Override
    public List<Video> VideoDTOTranslator(List<SearchResult> searchResultsList) {

        List<Video> videos = new ArrayList<>();

        for(SearchResult result : searchResultsList){
            Video video = new Video();
            video.setYouTubeVideoID(result.getId().getVideoId());
            video.setVideoTitle(result.getSnippet().getTitle());
            video.setVideoDescription(result.getSnippet().getDescription());
            video.setPublishedDate(new Date(result.getSnippet().getPublishedAt().getValue()));
            video.setYoutubeChannelID(result.getSnippet().getChannelId());
            video.setChannelTitle(result.getSnippet().getChannelTitle());
            video.setDefaultThumbnailURL(result.getSnippet().getThumbnails().getDefault().getUrl());
            video.setMediumThumbnailURL(result.getSnippet().getThumbnails().getMedium().getUrl());
            video.setHighThumbnailURL(result.getSnippet().getThumbnails().getHigh().getUrl());
            videos.add(video);
        }
        return videos;
    }

}
