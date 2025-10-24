package ru.mirea.fedoseev.practice41.task9;

public abstract class Furniture {
    protected String name;
    protected String material;
    protected double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();

    public abstract void displayInfo();

    @Override
    public String toString() {
        return getType() + "{name='" + name + "', material='" + material +
               "', price=" + price + "}";
    }
}
