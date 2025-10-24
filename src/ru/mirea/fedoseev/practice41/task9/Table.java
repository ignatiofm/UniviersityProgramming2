package ru.mirea.fedoseev.practice41.task9;

public class Table extends Furniture {
    private int seats;

    public Table(String name, String material, double price, int seats) {
        super(name, material, price);
        this.seats = seats;
    }

    @Override
    public String getType() {
        return "Стол";
    }

    @Override
    public void displayInfo() {
        System.out.println("Стол: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Количество мест: " + seats);
    }
}
