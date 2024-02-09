// Circle.java
package Assignment8.geometry;

import Assignment8.Shape;

public class Circle extends Shape {
    private static final double PI = 3.14;
    private double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }
}

