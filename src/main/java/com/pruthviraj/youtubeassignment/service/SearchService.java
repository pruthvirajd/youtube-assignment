package com.pruthviraj.youtubeassignment.service;

import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchService {

    public Page<Video> getAll(Integer page, Integer size);

    public List<Video> searchForQueries(String query);

}
