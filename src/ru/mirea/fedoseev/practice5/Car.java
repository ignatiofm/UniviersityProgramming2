package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий автомобиль
 */
public class Car implements Nameable {
    private String name;
    private String brand;
    private int year;

    public Car(String name, String brand, int year) {
        this.name = name;
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
