package ru.mirea.fedoseev.practice41.task9;

import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {
    private List<Furniture> inventory;
    private String shopName;

    public FurnitureShop(String shopName) {
        this.shopName = shopName;
        this.inventory = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture) {
        inventory.add(furniture);
        System.out.println("Добавлена мебель: " + furniture.getName());
    }

    public void showInventory() {
        System.out.println("\n=== Каталог магазина " + shopName + " ===");
        if (inventory.isEmpty()) {
            System.out.println("Магазин пуст");
            return;
        }
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("\n" + (i + 1) + ".");
            inventory.get(i).displayInfo();
        }
    }

    public void showFurnitureByType(String type) {
        System.out.println("\n=== " + type + " в наличии ===");
        boolean found = false;
        for (Furniture furniture : inventory) {
            if (furniture.getType().equals(type)) {
                furniture.displayInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет мебели данного типа");
        }
    }

    public double getTotalValue() {
        double total = 0;
        for (Furniture furniture : inventory) {
            total += furniture.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop("Уютный дом");

        shop.addFurniture(new Chair("Офисное кресло", "Кожа", 15000, true));
        shop.addFurniture(new Chair("Стул кухонный", "Дерево", 5000, false));
        shop.addFurniture(new Table("Обеденный стол", "Дуб", 25000, 6));
        shop.addFurniture(new Table("Письменный стол", "ЛДСП", 12000, 1));
        shop.addFurniture(new Wardrobe("Шкаф-купе", "МДФ", 45000, 3, true));
        shop.addFurniture(new Sofa("Угловой диван", "Ткань", 55000, 5, true));
        shop.addFurniture(new Sofa("Диван-кровать", "Велюр", 38000, 3, true));

        shop.showInventory();

        shop.showFurnitureByType("Стул");
        shop.showFurnitureByType("Диван");

        System.out.println("\nОбщая стоимость мебели в магазине: " +
                          shop.getTotalValue() + " руб.");
    }
}
