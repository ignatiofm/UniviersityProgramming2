package ru.mirea.fedoseev.practice5;

/**
 * Главная демонстрационная программа для практической работы №5 (Интерфейсы)
 *
 * Практическая работа включает:
 * 1-2. Интерфейс Movable и классы MovablePoint, MovableCircle, MovableRectangle
 * 3. Интерфейс Nameable (Planet, Animal, Car)
 * 4. Интерфейс Priceable (Product, Service, Subscription)
 * 5. Повторная реализация Movable (дублирует задание 1-2)
 * 6-9. Интерфейс Printable (Book, Shop, Magazine)
 * 10. Интернет-магазин компьютеров (computerShop пакет)
 * 11. Интерфейс Convertable (конвертация температур)
 * 12. StringBuilder с undo (паттерн Команда)
 * 13. StringBuilder с наблюдателем (паттерн Observer)
 */
public class Practice5Demo {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   ПРАКТИЧЕСКАЯ РАБОТА №5: ИНТЕРФЕЙСЫ В JAVA                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        testMovable();
        testNameable();
        testPriceable();
        testPrintable();

        System.out.println("\n=================================================================");
        System.out.println("ДЛЯ ЗАПУСКА ДРУГИХ ЗАДАНИЙ:");
        System.out.println("  10. computerShop.ComputerShopDemo - Интернет-магазин компьютеров");
        System.out.println("  11. TemperatureConverterDemo - Конвертер температур");
        System.out.println("  12. stringBuilder.UndoableStringBuilderDemo - StringBuilder с undo");
        System.out.println("  13. observer.ObservableStringBuilderDemo - StringBuilder с Observer");
        System.out.println("=================================================================");
    }

    /**
     * Задания 1-2: Тестирование интерфейса Movable
     */
    private static void testMovable() {
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАНИЯ 1-2: ИНТЕРФЕЙС MOVABLE                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // MovablePoint
        System.out.println("--- MovablePoint ---");
        MovablePoint point = new MovablePoint(0, 0, 5, 10);
        System.out.println("Исходная точка: " + point);
        point.moveRight();
        System.out.println("После moveRight(): " + point);
        point.moveDown();
        System.out.println("После moveDown(): " + point);

        // MovableCircle
        System.out.println("\n--- MovableCircle ---");
        MovableCircle circle = new MovableCircle(10, 10, 3, 3, 5);
        System.out.println("Исходный круг: " + circle);
        circle.moveUp();
        System.out.println("После moveUp(): " + circle);
        circle.moveLeft();
        System.out.println("После moveLeft(): " + circle);

        // MovableRectangle
        System.out.println("\n--- MovableRectangle ---");
        MovableRectangle rect = new MovableRectangle(0, 0, 10, 10, 2, 2);
        System.out.println("Исходный прямоугольник: " + rect);
        System.out.println("Тест скорости: " + (rect.speedTest() ? "ПРОЙДЕН" : "НЕ ПРОЙДЕН"));
        rect.moveRight();
        System.out.println("После moveRight(): " + rect);
        rect.moveDown();
        System.out.println("После moveDown(): " + rect);
    }

    /**
     * Задание 3: Тестирование интерфейса Nameable
     */
    private static void testNameable() {
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАНИЕ 3: ИНТЕРФЕЙС NAMEABLE                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        Nameable[] nameables = {
            new Planet("Земля", 5.972e24, 6371),
            new Planet("Марс", 6.39e23, 3389.5),
            new Animal("Барсик", "Кот", 3),
            new Animal("Шарик", "Собака", 5),
            new Car("Model 3", "Tesla", 2023),
            new Car("Camry", "Toyota", 2022)
        };

        System.out.println("Объекты с именами:");
        for (Nameable n : nameables) {
            System.out.println("  - " + n.getName() + " (" + n.getClass().getSimpleName() + ")");
        }
    }

    /**
     * Задание 4: Тестирование интерфейса Priceable
     */
    private static void testPriceable() {
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАНИЕ 4: ИНТЕРФЕЙС PRICEABLE                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        Priceable[] priceables = {
            new Product("Ноутбук", 85000, "Электроника"),
            new Product("Мышь", 1500, "Электроника"),
            new Service("Стрижка", 800, 30),
            new Service("Массаж", 2500, 60),
            new Subscription("Netflix", 999, 12),
            new Subscription("Spotify", 199, 6)
        };

        System.out.println("Объекты с ценами:");
        double total = 0;
        for (Priceable p : priceables) {
            System.out.printf("  - %s: %.2f руб.%n", p, p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("\nОбщая стоимость: %.2f руб.%n", total);
    }

    /**
     * Задания 6-9: Тестирование интерфейса Printable
     */
    private static void testPrintable() {
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАНИЯ 6-9: ИНТЕРФЕЙС PRINTABLE                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // Создаем магазины
        Shop shop1 = new Shop("TechnoWorld", "ул. Ленина, 15");
        shop1.addItem("Ноутбуки");
        shop1.addItem("Смартфоны");
        shop1.addItem("Планшеты");

        Shop shop2 = new Shop("BookHouse", "пр. Мира, 42");
        shop2.addItem("Художественная литература");
        shop2.addItem("Учебники");

        // Создаем массив Printable
        Printable[] printables = {
            new Book("Война и мир", "Л.Н. Толстой", 1869),
            new Book("Мастер и Маргарита", "М.А. Булгаков", 1967),
            shop1,
            new Magazine("National Geographic", 156, "Декабрь"),
            shop2,
            new Book("1984", "Джордж Оруэлл", 1949),
            new Magazine("Forbes", 342, "Январь")
        };

        System.out.println("=== Печать всех объектов ===");
        for (Printable p : printables) {
            p.print();
        }

        // Используем статические методы для фильтрации
        Book.printBooks(printables);
        Shop.printShops(printables);
        Magazine.printMagazines(printables);
    }
}
