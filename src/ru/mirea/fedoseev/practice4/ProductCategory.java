package ru.mirea.fedoseev.practice4;

public enum ProductCategory {
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    BOOKS("Книги"),
    FOOD("Продукты питания"),
    SPORTS("Спортивные товары");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
