package com.pruthviraj.youtubeassignment.repository;

import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoRepository extends JpaRepository<Video,Integer> {

    /**
     * @param title for searching title of the video for query string
     * @return list of videos which match to query string
     */
    List<Video> findByVideoTitleContaining(String title);

    /**
     * @param description for searching description of the video for query string
     * @return list of videos which match to query string
     */
    List<Video> findByVideoDescriptionContaining(String description);
}
