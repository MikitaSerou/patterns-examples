package com.example.patterns.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    static Map<String, TreeType> treeTypes =  new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherData){
        TreeType result = treeTypes.get(name);
        if (result == null){
            result = new TreeType(name, color, otherData);
            treeTypes.put(name, result);
        }
        return result;
    }
}
