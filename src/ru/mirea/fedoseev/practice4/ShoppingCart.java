package ru.mirea.fedoseev.practice4;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
        System.out.println("Товар добавлен в корзину: " + product.getName());
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("\n=== Ваша корзина ===");
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Product p = items.get(i);
            System.out.println((i + 1) + ". " + p);
            total += p.getPrice();
        }
        System.out.println("Итого: " + total + " руб.");
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста. Нечего покупать.");
            return;
        }
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        System.out.println("\n=== Оформление покупки ===");
        System.out.println("Всего товаров: " + items.size());
        System.out.println("Сумма к оплате: " + total + " руб.");
        System.out.println("Спасибо за покупку!");
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
