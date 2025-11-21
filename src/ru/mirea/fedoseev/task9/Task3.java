package ru.mirea.fedoseev.task9;

/**
 * Задание 3: Вопросы о статических и нестатических методах
 *
 * 1) Можно ли вызвать метод экземпляра или обратиться к переменной экземпляра из статического метода?
 *    Ответ: НЕТ, напрямую нельзя. Статический метод принадлежит классу, а не объекту.
 *           Но можно создать объект класса и через него вызвать метод экземпляра.
 *
 * 2) Можно ли вызвать статический метод или обратиться к статической переменной из метода экземпляра?
 *    Ответ: ДА, можно. Метод экземпляра может обращаться как к членам экземпляра,
 *           так и к статическим членам класса.
 *
 * 3) Исправленная программа (оригинал содержал следующие ошибки):
 *    - method1() вызывается из статического main(), поэтому должен быть static
 *    - переменная c объявлена вне метода (на уровне класса нужны модификаторы доступа)
 *    - method2() пытается обратиться к c, но c может быть не инициализирован
 *    - нет класса Circle
 */
public class Task3 {
    // Переменная экземпляра (теперь правильно объявлена)
    private SimpleCircle c = new SimpleCircle();

    public static void main(String[] args) {
        // Создаем объект для вызова нестатического метода
        Task3 obj = new Task3();
        obj.method1();
    }

    // method1() теперь нестатический (или можно сделать статическим, но тогда нужно изменить логику)
    public void method1() {
        method2();
    }

    // method2() вызывает getArea() у объекта c
    public void method2() {
        System.out.println("What is area " + c.getArea());
    }
}

// Простой класс Circle для демонстрации
class SimpleCircle {
    private double radius = 5.0;

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

/**
 * АЛЬТЕРНАТИВНОЕ РЕШЕНИЕ (все методы статические):
 */
class Task3Alternative {
    // Статическая переменная
    private static SimpleCircle c = new SimpleCircle();

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        System.out.println("What is area " + c.getArea());
    }
}
