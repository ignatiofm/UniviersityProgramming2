package ru.mirea.fedoseev.practice6;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public boolean speedTest() {
        return topLeft.getxSpeed() == bottomRight.getxSpeed()
                && topLeft.getySpeed() == bottomRight.getySpeed();
    }

    @Override
    public void moveUp() {
        if (speedTest()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        } else {
            System.out.println("Ошибка: точки имеют разные скорости!");
        }
    }

    @Override
    public void moveDown() {
        if (speedTest()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        } else {
            System.out.println("Ошибка: точки имеют разные скорости!");
        }
    }

    @Override
    public void moveLeft() {
        if (speedTest()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        } else {
            System.out.println("Ошибка: точки имеют разные скорости!");
        }
    }

    @Override
    public void moveRight() {
        if (speedTest()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        } else {
            System.out.println("Ошибка: точки имеют разные скорости!");
        }
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", speedTest=" + speedTest() +
                '}';
    }
}
