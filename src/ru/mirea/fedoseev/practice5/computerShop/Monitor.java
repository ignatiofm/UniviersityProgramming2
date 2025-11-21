package ru.mirea.fedoseev.practice5.computerShop;

/**
 * Класс, представляющий монитор
 */
public class Monitor {
    private double size;
    private String resolution;
    private String type;

    public Monitor(double size, String resolution, String type) {
        this.size = size;
        this.resolution = resolution;
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public String getResolution() {
        return resolution;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return size + "\" " + resolution + " " + type;
    }
}
