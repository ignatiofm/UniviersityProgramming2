package ru.mirea.fedoseev.practice4;

public class TShirt extends Clothes implements MenClothing, WomenClothing {

    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Одеваем мужчину в футболку: " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеваем женщину в футболку: " + this);
    }
}
