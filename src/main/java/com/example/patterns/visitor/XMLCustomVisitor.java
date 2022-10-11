package com.example.patterns.visitor;

import com.example.patterns.visitor.shapes.*;

public class XMLCustomVisitor implements Visitor {

    //Not using XML lib because must show any custom, manual-written code. Just example

    public String printMassExcel(Shape... shapes) {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (Shape shape :
                shapes) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    public String visitDot(Dot d) {
        return "<dot>" + "\n" +
                "    <id>" + d.getId() + "</id>" + "\n" +
                "    <x>" + d.getX() + "</x>" + "\n" +
                "    <y>" + d.getY() + "</y>" + "\n" +
                "</dot>";
    }

    public String visitCircle(Circle c) {
        return "<circle>" + "\n" +
                "    <id>" + c.getId() + "</id>" + "\n" +
                "    <x>" + c.getX() + "</x>" + "\n" +
                "    <y>" + c.getY() + "</y>" + "\n" +
                "    <radius>" + c.getRadius() + "</radius>" + "\n" +
                "</circle>";
    }

    public String visitRectangle(Rectangle r) {
        return "<rectangle>" + "\n" +
                "    <id>" + r.getId() + "</id>" + "\n" +
                "    <x>" + r.getX() + "</x>" + "\n" +
                "    <y>" + r.getY() + "</y>" + "\n" +
                "    <width>" + r.getWidth() + "</width>" + "\n" +
                "    <height>" + r.getHeight() + "</height>" + "\n" +
                "</rectangle>";
    }

    public String visitCompoundGraphic(CompoundShape cg) {
        return "<compound_graphic>" + "\n" +
                "   <id>" + cg.getId() + "</id>" + "\n" +
                handleChildFigure(cg) +
                "</compound_graphic>";
    }

    private String handleChildFigure(CompoundShape cg) {
    StringBuilder sb = new StringBuilder();
        for (Shape shape:
                cg.getChildren()) {
            String xmlChild = shape.accept(this);
            xmlChild = "    " + xmlChild.replace("\n", "\n    ") + "\n";
            sb.append(xmlChild);
        }
        return sb.toString();
    }
}
