package com.example.patterns.visitor.shapes;

import com.example.patterns.visitor.Visitor;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Setter
@Getter
public class Circle extends Dot{
    int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    @Override
    public void move(int x, int y) {
        log.info("Move circle");
    }

    @Override
    public void draw() {
        log.info("Draw circle");
    }
}
