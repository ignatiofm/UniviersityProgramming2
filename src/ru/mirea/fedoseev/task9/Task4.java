package ru.mirea.fedoseev.task9;

import java.util.Date;

/**
 * Задание 4: Найти ошибки в программе
 *
 * ОШИБКИ В ОРИГИНАЛЬНОЙ ПРОГРАММЕ:
 * 1. System.out.println(dates[0]) - выведет "null", так как массив создан, но элементы не инициализированы
 * 2. System.out.println(dates[0].toString()) - вызовет NullPointerException,
 *    так как dates[0] равен null, и мы пытаемся вызвать метод у null
 *
 * ИСПРАВЛЕНИЕ:
 * Нужно инициализировать элементы массива перед использованием
 */
public class Task4 {
    public static void main(String[] args) {
        // Оригинальная программа (с ошибками):
        System.out.println("=== ОРИГИНАЛЬНАЯ ПРОГРАММА (С ОШИБКАМИ) ===");
        Date[] dates = new Date[10];

        // Это выведет null, но не вызовет ошибку
        System.out.println("dates[0] = " + dates[0]);

        // Это вызовет NullPointerException!
        try {
            System.out.println(dates[0].toString());
        } catch (NullPointerException e) {
            System.out.println("ОШИБКА: NullPointerException - dates[0] равен null!");
        }

        // ИСПРАВЛЕННАЯ ПРОГРАММА:
        System.out.println("\n=== ИСПРАВЛЕННАЯ ПРОГРАММА ===");
        Date[] fixedDates = new Date[10];

        // Инициализируем элементы массива
        for (int i = 0; i < fixedDates.length; i++) {
            fixedDates[i] = new Date();
        }

        // Теперь можно безопасно использовать
        System.out.println("fixedDates[0] = " + fixedDates[0]);
        System.out.println("fixedDates[0].toString() = " + fixedDates[0].toString());

        // Выводим все даты
        System.out.println("\nВсе даты в массиве:");
        for (int i = 0; i < fixedDates.length; i++) {
            System.out.println("Date[" + i + "] = " + fixedDates[i]);
        }
    }
}
