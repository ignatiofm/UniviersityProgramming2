package ru.mirea.fedoseev.practice41.task1;

public class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "white";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getType() {
        return "Shape";
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Shape{color='" + color + "', filled=" + filled + "}";
    }
}
