package com.pruthviraj.youtubeassignment.service;

import com.pruthviraj.youtubeassignment.model.Video;

import java.util.List;

public interface SearchService {

    public List<Video> getAll();

    public List<Video> searchForQueries(String query);

}
