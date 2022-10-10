package com.example.patterns.proxy;

import com.example.patterns.proxy.hosting.VideoHostingProxy;
import com.example.patterns.proxy.hosting.VideoHostingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoProxy {
    public static void main(String[] args) {
        Downloader standardDownloader = new Downloader(new VideoHostingService());
        Downloader proxyDownloader = new Downloader(new VideoHostingProxy());

        long standardTime = test(standardDownloader);
        long withCacheTime = test(proxyDownloader);
        log.info("Time saved by caching proxy: " + (standardTime - withCacheTime) + "ms");

    }

    private static long test(Downloader downloader) {
        long startedTime = System.currentTimeMillis();
        downloader.renderPopularVideosPage();
        downloader.renderMockPage("catzzzzzzzzz");
        downloader.renderPopularVideosPage();
        downloader.renderMockPage("dancesvideoo");
        downloader.renderMockPage("catzzzzzzzzz");
        downloader.renderMockPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startedTime;
        log.info("Total elapsed time: " + estimatedTime + "ms\n");

        return estimatedTime;
    }
}
