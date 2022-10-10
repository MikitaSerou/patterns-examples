package com.example.patterns.proxy.hosting;

import com.example.patterns.proxy.Video;

import java.util.Map;

public interface VideoLibrary {
    Map<String, Video> popularVideos();

    Video getVideo(String videoId);
}
