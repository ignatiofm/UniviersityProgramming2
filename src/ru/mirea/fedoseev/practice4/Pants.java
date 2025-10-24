package ru.mirea.fedoseev.practice4;

public class Pants extends Clothes implements MenClothing, WomenClothing {

    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Одеваем мужчину в штаны: " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеваем женщину в штаны: " + this);
    }
}
