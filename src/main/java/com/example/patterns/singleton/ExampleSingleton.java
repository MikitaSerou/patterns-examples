package com.example.patterns.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleSingleton {
    public static void main(String[] args) {
        log.info("=============Singleton naive example start=============");
        SingletonNaive singleton = SingletonNaive.getInstance("Mark");
        SingletonNaive singletonAnother = SingletonNaive.getInstance("Josh");
        log.info("singleton hash: " + singleton.hashCode());
        log.info("singleton name: " + singleton.getName());
        log.info("singletonAnother hash: " + singletonAnother.hashCode());
        log.info("singletonAnother name: " + singletonAnother.getName());
        log.info("=============Singleton naive example end=============");


        log.info("=============Singleton multithreading example start=============");
        MultiThreadedSingleton multiThreadedSingleton = MultiThreadedSingleton.getInstance("Tony");
        MultiThreadedSingleton multiThreadedSingletonAnother = MultiThreadedSingleton.getInstance("Greg");
        log.info("multiThreadedSingleton hash: " + multiThreadedSingleton.hashCode());
        log.info("multiThreadedSingleton name: " + multiThreadedSingleton.getName());
        log.info("multiThreadedSingletonAnother hash: " + multiThreadedSingletonAnother.hashCode());
        log.info("multiThreadedSingletonAnother name: " + multiThreadedSingletonAnother.getName());
        log.info("=============Singleton multithreading example end=============");
    }
}
