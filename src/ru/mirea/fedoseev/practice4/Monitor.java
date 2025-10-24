package ru.mirea.fedoseev.practice4;

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

    public void setSize(double size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("  Монитор: " + size + " дюймов");
        System.out.println("  Разрешение: " + resolution);
        System.out.println("  Тип: " + type);
    }

    @Override
    public String toString() {
        return "Monitor{size=" + size + "\", resolution='" + resolution + "', type='" + type + "'}";
    }
}
