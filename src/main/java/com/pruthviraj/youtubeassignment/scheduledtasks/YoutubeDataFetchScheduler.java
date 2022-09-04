package com.pruthviraj.youtubeassignment.scheduledtasks;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.model.SearchResult;
import com.pruthviraj.youtubeassignment.external.YoutubeDataFetchImpl;
import com.pruthviraj.youtubeassignment.manager.VideoManagerImpl;
import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class YoutubeDataFetchScheduler {

    @Autowired
    YoutubeDataFetchImpl youtubeDataFetch;

    @Autowired
    VideoManagerImpl videoManager;

    public static int index;

    @Scheduled(cron = "*/10 * * * * *")
    public void fetchAndStoreYoutubeData() {

        List<String> apiKeys = youtubeDataFetch.getAPIKeys();

        String key = apiKeys.get(index);

        try {
            if (index < apiKeys.size()) {
                List<SearchResult> response = youtubeDataFetch.fetchData(key);
                List<Video> videos = videoManager.VideoDTOTranslator(response);
                videoManager.insertVideos(videos);
                System.out.println("Updated Database.");
            }
        }
        catch (GoogleJsonResponseException e) {
            if (e.getDetails().getErrors().stream().anyMatch(i -> i.getReason().equals("quotaExceeded"))) {
                System.err.println("Quota Exceeded for current API key.\nUsing next API key.");
                index++;
            }
            if (index == apiKeys.size()) {
                System.err.println("Quota Exceeded for all provided API keys.\n Please provide new API keys.");
            }
        }
        catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        }
        catch (Throwable t) {
            t.printStackTrace();
        }

    }

}


