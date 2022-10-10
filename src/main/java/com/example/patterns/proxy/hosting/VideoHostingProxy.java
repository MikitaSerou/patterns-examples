package com.example.patterns.proxy.hosting;

import com.example.patterns.proxy.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class VideoHostingProxy implements VideoLibrary {

    private final VideoHostingService videoHostingService = new VideoHostingService();
    private Map<String, Video> cachePopular = new HashMap<>();
    private final Map<String, Video> cacheAll = new HashMap<>();

    @Override
    public Map<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            log.info("Fill popular videos cache.");
            cachePopular = videoHostingService.popularVideos();
        } else {
            log.info("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            log.info("Put video into general cache.");
            video = videoHostingService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            log.info("Retrieved video " + videoId + " from cache.");
        }
        return video;
    }
}
