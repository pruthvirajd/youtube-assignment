package com.pruthviraj.youtubeassignment.external;

import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.model.Video;

import java.util.List;

public interface YoutubeDataFetch {

    public List<String> getAPIKeys();

    public List<SearchResult> fetchData(String apiKey) throws Exception;

}
