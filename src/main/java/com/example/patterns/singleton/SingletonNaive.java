package com.example.patterns.singleton;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonNaive {
    public static SingletonNaive instance;
    @Getter
    private final String name;

    private SingletonNaive(String name){
        this.name = name;
    }

    public static SingletonNaive getInstance(String name){
        log.info("SingletonNaive getInstance method entering");
        if (instance == null) {
            log.warn("Haven't singleton instance. Create instance");
            instance = new SingletonNaive(name);
            log.info("Created new singleton instance: " + instance.hashCode());
            return instance;
        }
        log.info("Singleton instance already create (" + instance.hashCode() + "). Returning existing instance");
        return instance;
    }
}
