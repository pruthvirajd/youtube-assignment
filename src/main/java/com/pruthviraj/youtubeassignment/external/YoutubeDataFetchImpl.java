package com.pruthviraj.youtubeassignment.external;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class YoutubeDataFetchImpl implements YoutubeDataFetch {

    @Value("${youtube.api.keys}")
    private String API_KEYS;

    @Value("${youtube.api.query}")
    private String query;

    /**
     * @return Returns a list of all the API keys available
     */
    @Override
    public List<String> getAPIKeys() {
        return Arrays.asList(API_KEYS.split(",", -1));
    }

    /**
     * Hits the YouTube Data API V3 for the Video Information
     * @param apiKey Accepts a key to make the API call
     * @return The search results of API response
     * @throws Exception when API Key expires or if IO error occurs
     */
    @Override
    public List<SearchResult> fetchData(String apiKey) throws Exception {

        //Using Youtube Data API V3 Jar
        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequest -> {
        }).setApplicationName("YoutubeVideoInfo").build();

        YouTube.Search.List search = youtube.search().list("snippet");
        search.setKey(apiKey);
        search.setQ(query);
        search.setType("video");
        search.setRelevanceLanguage("en");
        search.setOrder("date");

        //For finding videos that were uploaded after the previous API hit
        search.setPublishedAfter(new DateTime(System.currentTimeMillis() - 15000L));

        //Setting all the required fields
        search.setFields("items(" +
                "id/videoId," +
                "snippet/publishedAt," +
                "snippet/channelId," +
                "snippet/title," +
                "snippet/description," +
                "snippet/thumbnails/default/url," +
                "snippet/thumbnails/medium/url," +
                "snippet/thumbnails/high/url," +
                "snippet/channelTitle)");
        search.setMaxResults(50L);
        SearchListResponse searchResponse = search.execute();
        List<SearchResult> searchResultList = searchResponse.getItems();
        return searchResultList;
    }

}
