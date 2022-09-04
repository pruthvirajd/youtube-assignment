package com.pruthviraj.youtubeassignment.manager;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
@Service
public interface VideoManager {

    /**
     * Gets all video information in pages from the database
     * @param pageable For determining page, size and sorting requirement
     * @return a page of videos
     */
    public Page<Video> getAll(Pageable pageable);

    /**
     * @param videos list of videos to insert into db
     */
    public void insertVideos(List<Video> videos);

    /**
     * @param query the input query user wants to search for
     * @return all videos whose title or description matches the search query
     */
    public List<Video> search(String query);

    /**
     * @param searchResultsList list of response objects from YouTube API hit
     * @return list of videos after converting the response objects to video model class
     */
    public List<Video> VideoDTOTranslator(List<SearchResult> searchResultsList);

}
