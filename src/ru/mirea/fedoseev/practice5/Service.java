package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий услугу
 */
public class Service implements Priceable {
    private String name;
    private double price;
    private int duration;

    public Service(String name, double price, int duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration + " minutes" +
                '}';
    }
}
