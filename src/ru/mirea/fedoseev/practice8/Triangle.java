package ru.mirea.fedoseev.practice8;

import java.awt.*;

public class Triangle extends Shape {
    private int width;
    private int height;

    public Triangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x + width / 2, x + width};
        int[] yPoints = {y + height, y, y + height};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
