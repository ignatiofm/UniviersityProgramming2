package ru.mirea.fedoseev.practice41.task9;

public class Chair extends Furniture {
    private boolean hasArmrests;

    public Chair(String name, String material, double price, boolean hasArmrests) {
        super(name, material, price);
        this.hasArmrests = hasArmrests;
    }

    @Override
    public String getType() {
        return "Стул";
    }

    @Override
    public void displayInfo() {
        System.out.println("Стул: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("С подлокотниками: " + (hasArmrests ? "Да" : "Нет"));
    }
}
