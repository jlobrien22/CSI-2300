// Shape.java
package Assignment8;

public abstract class Shape {
    protected String color;

    public Shape() {
        this.color = "blue";
    }

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();
}
