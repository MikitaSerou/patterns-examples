package com.example.patterns.visitor.shapes;

import com.example.patterns.visitor.Visitor;


public interface Shape {
    default void move(int x, int y) {
        System.out.println("Move shape for (x,y): (" + x + "," + y + ")");
    }

    default void draw(){
        System.out.println("Draw shape");
    }

    String accept(Visitor visitor);
}
