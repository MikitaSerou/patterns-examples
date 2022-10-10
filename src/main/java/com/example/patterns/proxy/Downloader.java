package com.example.patterns.proxy;

import com.example.patterns.proxy.hosting.VideoLibrary;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class Downloader {
    private final VideoLibrary api;

    public void renderMockPage(String videoId) {
        Video video = api.getVideo(videoId);
        log.info("\n==============================");
        log.info("---Video page---");
        log.info("ID:  " + video.getId());
        log.info("Title: " + video.getTitle());
        log.info("Video: " + video.getData());
        log.info("==============================\n");
    }

    public void renderPopularVideosPage() {
        Map<String, Video> popularVideos = api.popularVideos();
        log.info("\n==============================");
        log.info("---Most popular videos---");
        for (Video video : popularVideos.values()) {
            log.info("ID: " + video.getId() + " / Title: " + video.getTitle());
        }
        log.info("==============================\n");
    }
}
