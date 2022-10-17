package com.example.patterns.flyweight;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class DemoFlyweight {

    static int CANVAS_SIZE = 500;
    static int TREES_COUNT = 10000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        for (int i = 0; i < Math.floor(TREES_COUNT / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", new Color(0,100,49), "Young oak");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", new Color(255,140,0), "Very old wisdom oak");

        }
        forest.setVisible(true);
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
