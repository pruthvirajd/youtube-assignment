package com.pruthviraj.youtubeassignment.repository;

import com.pruthviraj.youtubeassignment.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoRepository extends JpaRepository<Video,Integer> {

    List<Video> findByVideoTitleContaining(String title);

    List<Video> findByVideoDescriptionContaining(String description);
}
