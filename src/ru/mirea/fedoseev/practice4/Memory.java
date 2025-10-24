package ru.mirea.fedoseev.practice4;

public class Memory {
    private String type;
    private int size;

    public Memory(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayInfo() {
        System.out.println("  Память: " + type);
        System.out.println("  Объем: " + size + " GB");
    }

    @Override
    public String toString() {
        return "Memory{type='" + type + "', size=" + size + " GB}";
    }
}
