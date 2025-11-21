package ru.mirea.fedoseev.task9;

import java.util.Random;

/**
 * Домашнее задание 2: Клиент для класса StopWatch
 * Программа вычисляет время выполнения сортировки 100 000 чисел методом выбора
 */
public class StopWatchTest {
    public static void main(String[] args) {
        // Размер массива
        final int SIZE = 100000;

        // Создаем массив из 100 000 случайных чисел
        System.out.println("Создание массива из " + SIZE + " случайных чисел...");
        int[] array = generateRandomArray(SIZE);
        System.out.println("Массив создан.");

        // Создаем объект StopWatch
        StopWatch stopWatch = new StopWatch();

        // Запускаем секундомер
        System.out.println("\nНачало сортировки методом выбора...");
        stopWatch.start();

        // Выполняем сортировку методом выбора
        selectionSort(array);

        // Останавливаем секундомер
        stopWatch.stop();
        System.out.println("Сортировка завершена.");

        // Выводим результаты
        System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
        System.out.println("Время выполнения сортировки: " + stopWatch.getElapsedTime() + " мс");
        System.out.println("Время выполнения сортировки: " + (stopWatch.getElapsedTime() / 1000.0) + " секунд");

        // Проверяем, что массив отсортирован
        if (isSorted(array)) {
            System.out.println("\nМассив успешно отсортирован!");
        } else {
            System.out.println("\nОШИБКА: Массив не отсортирован!");
        }

        // Выводим первые и последние 10 элементов для проверки
        System.out.println("\nПервые 10 элементов:");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\nПоследние 10 элементов:");
        for (int i = SIZE - 10; i < SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Генерирует массив случайных целых чисел
     * @param size размер массива
     * @return массив случайных чисел
     */
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000); // Случайные числа от 0 до 999999
        }
        return array;
    }

    /**
     * Сортировка методом выбора (Selection Sort)
     * Алгоритм:
     * 1. Находим минимальный элемент в неотсортированной части
     * 2. Меняем его местами с первым элементом неотсортированной части
     * 3. Повторяем для оставшейся части массива
     *
     * Сложность: O(n²)
     *
     * @param array массив для сортировки
     */
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // Находим индекс минимального элемента в неотсортированной части
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Меняем местами минимальный элемент с первым элементом неотсортированной части
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * Проверяет, отсортирован ли массив по возрастанию
     * @param array массив для проверки
     * @return true, если массив отсортирован, иначе false
     */
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
