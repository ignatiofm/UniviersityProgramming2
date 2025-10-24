package ru.mirea.fedoseev.practice41.task9;

public class Sofa extends Furniture {
    private int seats;
    private boolean isFoldable;

    public Sofa(String name, String material, double price, int seats, boolean isFoldable) {
        super(name, material, price);
        this.seats = seats;
        this.isFoldable = isFoldable;
    }

    @Override
    public String getType() {
        return "Диван";
    }

    @Override
    public void displayInfo() {
        System.out.println("Диван: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Количество мест: " + seats);
        System.out.println("Раскладной: " + (isFoldable ? "Да" : "Нет"));
    }
}
