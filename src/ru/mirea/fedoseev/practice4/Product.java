package ru.mirea.fedoseev.practice4;

public class Product {
    private int id;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(int id, String name, double price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + name + " - " + price + " руб.";
    }
}
