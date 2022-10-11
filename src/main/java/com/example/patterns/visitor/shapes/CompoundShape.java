package com.example.patterns.visitor.shapes;

import com.example.patterns.visitor.Visitor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Slf4j
@RequiredArgsConstructor
public class CompoundShape implements Shape {

    @NonNull
    int id;
    List<Shape> children = new ArrayList<>();

    public CompoundShape(@NonNull int id, Shape... children) {
        this.id = id;
        this.children = new ArrayList<>();
        this.children.addAll(Arrays.asList(children));
    }

    @Override
    public void move(int x, int y) {
        log.info("Move compound shape");
    }

    @Override
    public void draw() {
        log.info("Draw compound shape");
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape){
        children.add(shape);
    }
}
