package com.pruthviraj.youtubeassignment.external;

import com.google.api.services.youtube.model.SearchResult;

import java.util.List;

public interface YoutubeDataFetch {

    /**
     * @return a list of all the API keys available
     */
    List<String> getAPIKeys();

    /**
     * Hits the YouTube Data API V3 for the Video Information
     * @param apiKey accepts a key to make the API call
     * @return the search results of API response
     * @throws Exception when API Key expires or if IO error occurs
     */
    List<SearchResult> fetchData(String apiKey) throws Exception;

}

