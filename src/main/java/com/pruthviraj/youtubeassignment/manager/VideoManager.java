package com.pruthviraj.youtubeassignment.manager;

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

    public List<Video> searchForQuery(List<String> queries);

}
