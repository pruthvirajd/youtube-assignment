package com.pruthviraj.youtubeassignment.service;

import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchService {

    /**
     * @param page for returning the requesting page
     * @param size for defining size per page
     * @return a page of list of Videos in descending order of date
     */
    public Page<Video> getAll(Integer page, Integer size);

    /**
     * @param query search query that the user wants
     * @return all videos whose title or description is similar to the query
     */
    public List<Video> search(String query);

}
