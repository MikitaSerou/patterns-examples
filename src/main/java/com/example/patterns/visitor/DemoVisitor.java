package com.example.patterns.visitor;

import com.example.patterns.visitor.shapes.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoVisitor {

    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);
        CompoundShape compoundShape = new CompoundShape(4, dot, circle, rectangle);
        CompoundShape anotherCompoundShape = new CompoundShape(5, dot);

        compoundShape.add(anotherCompoundShape);
        export(circle, compoundShape);
    }

    public static void export(Shape... shapes) {
        XMLCustomVisitor xmlCustomVisitor = new XMLCustomVisitor();
        log.info(xmlCustomVisitor.printMassExcel(shapes));
    }
}
