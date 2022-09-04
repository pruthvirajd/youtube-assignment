package com.pruthviraj.youtubeassignment.manager;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.model.Video;
import com.pruthviraj.youtubeassignment.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class VideoManagerImpl implements VideoManager {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAll() {
        System.out.println("Getting All Videos");
        return videoRepository.findAll();
    }

    @Override
    public void insertVideos(List<Video> videos){
        System.out.println("Inserting " +videos.size() + " videos");
        if(videos.size()>0)
            videoRepository.saveAll(videos);
    }

    @Override
    public List<Video> searchForQuery(String query) {
        System.out.println("Search for following query: "+query);
        //TODO: Add fuzzy Search
        List<String> queries = new ArrayList<>();
        queries.add(query);

        List<Video> videos = new ArrayList<>();
        queries.stream().forEach(q ->{videos.addAll(videoRepository.findByVideoTitleContaining(q));
            videos.addAll(videoRepository.findByVideoDescriptionContaining(q));});

        return videos;
    }

    @Override
    public List<Video> VideoDTOTranslator(List<SearchResult> searchResultsList) {

        List<Video> videos = new ArrayList<>();

        for(SearchResult result : searchResultsList){
            Video video = new Video(result.getId().getVideoId(), result.getSnippet().getTitle(), result.getSnippet().getDescription(),
                    new Date(result.getSnippet().getPublishedAt().getValue()), result.getSnippet().getChannelId(),
                    result.getSnippet().getChannelTitle(), result.getSnippet().getThumbnails().getDefault().getUrl(),
                    result.getSnippet().getThumbnails().getMedium().getUrl(),
                    result.getSnippet().getThumbnails().getHigh().getUrl());
            videos.add(video);
        }
        return videos;
    }

}
