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

    public Page<Video> getAll(Pageable pageable);

    public void insertVideos(List<Video> videos);

    public List<Video> searchForQuery(String queries);

    public List<Video> VideoDTOTranslator(List<SearchResult> searchResults);

}
