package com.pruthviraj.youtubeassignment.service;

import com.pruthviraj.youtubeassignment.manager.VideoManagerImpl;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@ComponentScan({"com.pruthviraj.youtubeassignment"})
@RequestMapping(path="api/SearchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private VideoManagerImpl videoManager;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @Override
    public Page<Video> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page!=null ? page : 0, size!=null ? size : 5, Sort.Direction.DESC, "publishedDate");
        return videoManager.getAll(pageable);
    }

    @Override
    @GetMapping("/searchQuery")
    public List<Video> searchForQueries(@RequestParam String query) {
        return videoManager.searchForQuery(query);
    }
}
