package com.pruthviraj.youtubeassignment.service;

import com.pruthviraj.youtubeassignment.manager.VideoManagerImpl;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan({"com.pruthviraj.youtubeassignment"})
@RequestMapping(path="api/SearchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private VideoManagerImpl videoManager;

    //@GetMapping("/getAll/")
    public List<Video> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return videoManager.getAll();
    }

    @Override
    @GetMapping("/getAll/")
    public List<Video> getAll() {
        return videoManager.getAll();
    }

    @Override
    @GetMapping("/searchQuery")
    public List<Video> searchForQueries(@RequestParam String query) {
        return videoManager.searchForQuery(query);
    }
}
