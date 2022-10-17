package com.example.patterns.flyweight;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.awt.*;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tree {
    //coords
    int x;
    int y;
    TreeType type;

    public void draw(Graphics g){
        type.draw(g, x, y);
    }
}
