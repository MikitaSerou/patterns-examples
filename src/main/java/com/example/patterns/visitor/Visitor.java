package com.example.patterns.visitor;

import com.example.patterns.visitor.shapes.Circle;
import com.example.patterns.visitor.shapes.CompoundShape;
import com.example.patterns.visitor.shapes.Dot;
import com.example.patterns.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape compoundShape);
}
