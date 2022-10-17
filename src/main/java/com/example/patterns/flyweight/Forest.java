package com.example.patterns.flyweight;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Forest extends JFrame {
    List<Tree> forest = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherData){
        TreeType type = TreeTypeFactory.getTreeType(name, color, otherData);
        Tree tree =  new Tree(x, y, type);
        forest.add(tree);
    }

    @Override
    public void paint(Graphics graphics){
        for (Tree tree:
                forest) {
            tree.draw(graphics);
        }
    }
}
