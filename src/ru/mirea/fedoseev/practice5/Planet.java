package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий планету
 */
public class Planet implements Nameable {
    private String name;
    private double mass;
    private double radius;

    public Planet(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", radius=" + radius +
                '}';
    }
}
