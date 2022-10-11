package com.example.patterns.visitor.shapes;

import com.example.patterns.visitor.Visitor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Dot implements Shape {
    int id;
    int x;
    int y;

    @Override
    public void move(int x, int y) {
        log.info("Move dot");
    }

    @Override
    public void draw() {
        log.info("Draw dot");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }
}
