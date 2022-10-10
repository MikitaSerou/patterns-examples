package com.example.patterns.singleton;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadedSingleton {

    public static volatile MultiThreadedSingleton instance;
    @Getter
    private final String name;

    private MultiThreadedSingleton(String name) {
        this.name = name;
    }

    public static MultiThreadedSingleton getInstance(String name) {
        log.info("MultiThreadedSingleton getInstance method entering");
        if (instance == null) {
            log.info("MultiThreadedSingleton instance is not initialized ❌");
            synchronized (MultiThreadedSingleton.class) {
                log.info("Into synchronized method for creating MultiThreadedSingleton instance");
                if (instance == null) {
                    log.info("MultiThreadedSingleton instance is not initialized (checking in synchronized method)");
                    instance = new MultiThreadedSingleton(name);
                }
            }
        }
        log.info("MultiThreadedSingleton instance is initialized ✔");
        return instance;
    }
}
