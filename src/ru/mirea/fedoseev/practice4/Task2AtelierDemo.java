package ru.mirea.fedoseev.practice4;

public class Task2AtelierDemo {
    public static void main(String[] args) {
        Clothes[] clothes = {
            new TShirt(Size.M, 1500, "белый"),
            new TShirt(Size.S, 1200, "черный"),
            new Pants(Size.L, 3000, "синий"),
            new Pants(Size.M, 2800, "черный"),
            new Skirt(Size.S, 2500, "красный"),
            new Skirt(Size.XS, 2000, "розовый"),
            new Tie(Size.M, 800, "бордовый"),
            new Tie(Size.L, 850, "черный")
        };

        Atelier atelier = new Atelier();

        atelier.dressWomen(clothes);
        System.out.println();
        atelier.dressMan(clothes);

        System.out.println("\n=== Информация о размерах ===");
        for (Size size : Size.values()) {
            System.out.println("Размер: " + size +
                             ", Евро размер: " + size.getEuroSize() +
                             ", Описание: " + size.getDescription());
        }
    }
}
