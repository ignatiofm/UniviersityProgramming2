package ru.mirea.fedoseev.practice5;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий магазин
 */
public class Shop implements Printable {
    private String name;
    private String address;
    private List<String> items;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public void print() {
        System.out.println("Shop: " + name);
        System.out.println("Address: " + address);
        System.out.println("Items: " + items);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getItems() {
        return items;
    }

    /**
     * Статический метод для печати только магазинов из массива Printable
     */
    public static void printShops(Printable[] printables) {
        System.out.println("\n=== Печать только магазинов ===");
        for (Printable printable : printables) {
            if (printable instanceof Shop) {
                printable.print();
            }
        }
    }
}
