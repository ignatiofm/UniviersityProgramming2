package ru.mirea.fedoseev.practice5.computerShop;

/**
 * Перечисление марок компьютеров
 */
public enum ComputerBrand {
    HP("HP"),
    LENOVO("Lenovo"),
    ACER("Acer"),
    DELL("Dell"),
    ASUS("ASUS"),
    APPLE("Apple");

    private final String displayName;

    ComputerBrand(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
