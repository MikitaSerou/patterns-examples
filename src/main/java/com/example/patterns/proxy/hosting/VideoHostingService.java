package com.example.patterns.proxy.hosting;

import com.example.patterns.proxy.Video;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j

public class VideoHostingService implements VideoLibrary {

    private final String HOSTING = "https://youtube.com/";
    private final int MIN_RAND = 5;
    private final int MAX_RAND = 10;
    private final int THREAD_SLEEP_TIME = 100;

    @Override
    public Map<String, Video> popularVideos() {
        connectToServer(HOSTING);
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer(HOSTING + videoId);
        return getSomeVideo(videoId);
    }

    private int randomInt() {
        return MIN_RAND + (int) (Math.random() * ((MAX_RAND - MIN_RAND) + 1));
    }

    private void networkLatency() {
        int randomLatency = randomInt();
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        log.info("Connecting to: " + server);
        networkLatency();
        log.info("Connected to: " + server);
    }

    private Map<String, Video> getRandomVideos() {
        log.info("Download popular videos. . . . . . ");
        networkLatency();

        Map<String, Video> videos = new HashMap<>();
        videos.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        videos.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        videos.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        videos.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        videos.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        log.info("Complete! + \n");
        return videos;
    }

    private Video getSomeVideo(String videoId) {
        log.info("Downloading video with id: " + videoId);
        networkLatency();
        Video video = new Video(videoId, "Some title");

        log.info("Done! \n");
        return video;
    }
}
