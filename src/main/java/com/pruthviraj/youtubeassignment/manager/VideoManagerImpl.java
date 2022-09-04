package com.pruthviraj.youtubeassignment.manager;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.model.Video;
import com.pruthviraj.youtubeassignment.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoManagerImpl implements VideoManager {

    @Autowired
    private VideoRepository videoRepository;

    /**
     * Gets all video information in pages from the database
     * @param pageable For determining page, size and sorting requirement
     * @return a page of videos
     */
    @Override
    public Page<Video> getAll(Pageable pageable) {
        System.out.println("Getting All Videos");
        return videoRepository.findAll(pageable);
    }

    /**
     * @param videos list of videos to insert into db
     */
    @Override
    public void insertVideos(List<Video> videos) {
        System.out.println("Inserting " + videos.size() + " videos");
        if (videos.size() > 0)
            videoRepository.saveAll(videos);
    }

    /**
     * @param query the input query user wants to search for
     * @return all videos whose title or description matches the search query
     */
    @Override
    public List<Video> search(String query) {
        System.out.println("Search for following query: " + query);

        List<Video> videos = new ArrayList<>();
        videos.addAll(videoRepository.findByVideoTitleContaining(query));
        videos.addAll(videoRepository.findByVideoDescriptionContaining(query));
        videos = videos.stream().distinct().collect(Collectors.toList());

        return videos;
    }

    /**
     * @param searchResultsList list of response objects from YouTube API hit
     * @return list of videos after converting the response objects to video model class
     */
    @Override
    public List<Video> VideoDTOTranslator(List<SearchResult> searchResultsList) {

        List<Video> videos = new ArrayList<>();

        for (SearchResult result : searchResultsList) {
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
