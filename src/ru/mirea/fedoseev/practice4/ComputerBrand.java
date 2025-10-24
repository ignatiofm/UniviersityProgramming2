package ru.mirea.fedoseev.practice4;

public enum ComputerBrand {
    DELL("Dell"),
    HP("HP"),
    LENOVO("Lenovo"),
    ASUS("ASUS"),
    ACER("Acer"),
    APPLE("Apple");

    private final String displayName;

    ComputerBrand(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
