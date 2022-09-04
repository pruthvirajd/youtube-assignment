package com.pruthviraj.youtubeassignment.manager;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
@Service
public interface VideoManager {

    public List<Video>  getAll();

    public void insertVideos(List<Video> videos);

    public List<Video> searchForQuery(String queries);

    public List<Video> VideoDTOTranslator(List<SearchResult> searchResults);

}
