package com.aor.refactoring.example2;

public abstract class Shape {

    private double x;
    private double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getArea() throws Exception {
        throw new Exception("Shape with no type");
    }

    public double getPerimeter() throws Exception {
        throw new Exception("Shape with no type");
    }

    public abstract void draw(GraphicFramework graphics);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
