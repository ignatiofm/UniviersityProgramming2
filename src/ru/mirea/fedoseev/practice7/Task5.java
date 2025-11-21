package ru.mirea.fedoseev.practice7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Задание 5. Сравнение производительности ArrayList и LinkedList
 * по операциям вставки, удаления, добавления и поиска по образцу.
 */
public class Task5 {
    private static final int SMALL_SIZE = 1000;
    private static final int MEDIUM_SIZE = 10000;
    private static final int LARGE_SIZE = 100000;

    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("СРАВНЕНИЕ ПРОИЗВОДИТЕЛЬНОСТИ ArrayList И LinkedList");
        System.out.println(repeatChar('=', 80));
        System.out.println();

        testWithSize("МАЛЫЙ РАЗМЕР", SMALL_SIZE);
        System.out.println();

        testWithSize("СРЕДНИЙ РАЗМЕР", MEDIUM_SIZE);
        System.out.println();

        testWithSize("БОЛЬШОЙ РАЗМЕР", LARGE_SIZE);
    }

    /**
     * Тестирование производительности для указанного размера.
     */
    private static void testWithSize(String testName, int size) {
        System.out.println(testName + " (" + size + " элементов)");
        System.out.println(repeatChar('-', 80));

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("\n1. ДОБАВЛЕНИЕ В КОНЕЦ (add):");
        long arrayListAddTime = testAddToEnd(arrayList, size);
        long linkedListAddTime = testAddToEnd(linkedList, size);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListAddTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListAddTime);
        printWinner(arrayListAddTime, linkedListAddTime);

        System.out.println("\n2. ВСТАВКА В НАЧАЛО (add(0, element)):");
        long arrayListInsertStartTime = testInsertAtStart(arrayList, size / 10);
        long linkedListInsertStartTime = testInsertAtStart(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListInsertStartTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListInsertStartTime);
        printWinner(arrayListInsertStartTime, linkedListInsertStartTime);

        System.out.println("\n3. ВСТАВКА В СЕРЕДИНУ (add(size/2, element)):");
        long arrayListInsertMiddleTime = testInsertAtMiddle(arrayList, size / 10);
        long linkedListInsertMiddleTime = testInsertAtMiddle(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListInsertMiddleTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListInsertMiddleTime);
        printWinner(arrayListInsertMiddleTime, linkedListInsertMiddleTime);

        System.out.println("\n4. ДОСТУП ПО ИНДЕКСУ (get(index)):");
        long arrayListGetTime = testGet(arrayList, size / 10);
        long linkedListGetTime = testGet(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListGetTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListGetTime);
        printWinner(arrayListGetTime, linkedListGetTime);

        System.out.println("\n5. ПОИСК ПО ЗНАЧЕНИЮ (contains):");
        long arrayListSearchTime = testSearch(arrayList, size / 10);
        long linkedListSearchTime = testSearch(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListSearchTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListSearchTime);
        printWinner(arrayListSearchTime, linkedListSearchTime);

        System.out.println("\n6. УДАЛЕНИЕ ИЗ НАЧАЛА (remove(0)):");
        long arrayListRemoveStartTime = testRemoveFromStart(arrayList, size / 10);
        long linkedListRemoveStartTime = testRemoveFromStart(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListRemoveStartTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListRemoveStartTime);
        printWinner(arrayListRemoveStartTime, linkedListRemoveStartTime);

        System.out.println("\n7. УДАЛЕНИЕ ИЗ КОНЦА (remove(size-1)):");
        long arrayListRemoveEndTime = testRemoveFromEnd(arrayList, size / 10);
        long linkedListRemoveEndTime = testRemoveFromEnd(linkedList, size / 10);
        System.out.printf("   ArrayList:  %10d нс%n", arrayListRemoveEndTime);
        System.out.printf("   LinkedList: %10d нс%n", linkedListRemoveEndTime);
        printWinner(arrayListRemoveEndTime, linkedListRemoveEndTime);

        System.out.println("\n" + repeatChar('-', 80));
        printSummary(arrayListAddTime, linkedListAddTime,
                    arrayListInsertStartTime, linkedListInsertStartTime,
                    arrayListGetTime, linkedListGetTime,
                    arrayListRemoveStartTime, linkedListRemoveStartTime);
    }

    private static long testAddToEnd(List<Integer> list, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return System.nanoTime() - startTime;
    }

    private static long testInsertAtStart(List<Integer> list, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        return System.nanoTime() - startTime;
    }

    private static long testInsertAtMiddle(List<Integer> list, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(list.size() / 2, i);
        }
        return System.nanoTime() - startTime;
    }

    private static long testGet(List<Integer> list, int count) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
        return System.nanoTime() - startTime;
    }

    private static long testSearch(List<Integer> list, int count) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.contains(random.nextInt(list.size()));
        }
        return System.nanoTime() - startTime;
    }

    private static long testRemoveFromStart(List<Integer> list, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count && !list.isEmpty(); i++) {
            list.remove(0);
        }
        return System.nanoTime() - startTime;
    }

    private static long testRemoveFromEnd(List<Integer> list, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count && !list.isEmpty(); i++) {
            list.remove(list.size() - 1);
        }
        return System.nanoTime() - startTime;
    }

    private static void printWinner(long arrayListTime, long linkedListTime) {
        double ratio = (double) Math.max(arrayListTime, linkedListTime) / Math.min(arrayListTime, linkedListTime);
        if (arrayListTime < linkedListTime) {
            System.out.printf("   → ArrayList быстрее в %.2f раз%n", ratio);
        } else if (linkedListTime < arrayListTime) {
            System.out.printf("   → LinkedList быстрее в %.2f раз%n", ratio);
        } else {
            System.out.println("   → Примерно одинаковая производительность");
        }
    }

    private static void printSummary(long alAdd, long llAdd,
                                    long alInsert, long llInsert,
                                    long alGet, long llGet,
                                    long alRemove, long llRemove) {
        System.out.println("\nИТОГОВЫЙ ВЫВОД:");
        System.out.println("• ArrayList лучше для:");
        System.out.println("  - Доступа по индексу (get)");
        System.out.println("  - Добавления в конец (add)");
        System.out.println("  - Итерации по элементам");
        System.out.println();
        System.out.println("• LinkedList лучше для:");
        System.out.println("  - Вставки в начало");
        System.out.println("  - Удаления из начала");
        System.out.println("  - Частых вставок/удалений в середине");
    }
}
