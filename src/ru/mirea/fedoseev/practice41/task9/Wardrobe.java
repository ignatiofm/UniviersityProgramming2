package ru.mirea.fedoseev.practice41.task9;

public class Wardrobe extends Furniture {
    private int doors;
    private boolean hasMirror;

    public Wardrobe(String name, String material, double price, int doors, boolean hasMirror) {
        super(name, material, price);
        this.doors = doors;
        this.hasMirror = hasMirror;
    }

    @Override
    public String getType() {
        return "Шкаф";
    }

    @Override
    public void displayInfo() {
        System.out.println("Шкаф: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Количество дверей: " + doors);
        System.out.println("С зеркалом: " + (hasMirror ? "Да" : "Нет"));
    }
}
