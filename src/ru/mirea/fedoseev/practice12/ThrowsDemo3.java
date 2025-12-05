package ru.mirea.fedoseev.practice12;

import java.util.Scanner;

public class ThrowsDemo3 {

    public void getKey() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key (empty string will cause exception): ");
        String key = myScanner.nextLine();
        printDetails(key);
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("printDetails: не удалось получить данные, пробрасываем исключение...");
            throw e;
        }
    }

    private String getDetails(String key) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public void getKeySafe() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key (empty string will cause exception): ");
        String key = myScanner.nextLine();

        try {
            printDetailsSafe(key);
        } catch (Exception e) {
            System.out.println("Ошибка в getKeySafe: " + e.getMessage());
            System.out.println("Попробуйте ввести непустой ключ");
        }
    }

    public void printDetailsSafe(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    public static void main(String[] args) {
        ThrowsDemo3 demo = new ThrowsDemo3();

        System.out.println("=== Задание 7: Checked исключения и throws ===\n");

        System.out.println("--- Демонстрация цепочки вызовов ---");
        System.out.println("getKey() -> printDetails() -> getDetails()");
        System.out.println();

        System.out.println("--- Тест 1: Ввод с возможной ошибкой (перехват в main) ---");
        try {
            demo.getKey();
        } catch (Exception e) {
            System.out.println("\nИсключение поймано в main: " + e.getMessage());
            System.out.println("Стек вызовов:");
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().contains("ThrowsDemo3")) {
                    System.out.println("  at " + element);
                }
            }
        }

        System.out.println("\n--- Тест 2: Безопасная версия с внутренней обработкой ---");
        demo.getKeySafe();

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. Exception - checked исключение, требует обработки или throws");
        System.out.println("2. 'Unreported exception' - исключение не обработано и не объявлено");
        System.out.println("3. throws в сигнатуре - обязательство: метод может выбросить исключение");
        System.out.println("4. Вызывающий код ОБЯЗАН либо перехватить, либо тоже объявить throws");
        System.out.println("5. Два способа решения проблемы:");
        System.out.println("   a) Добавить try-catch в каждый метод цепочки");
        System.out.println("   b) Добавить throws Exception и обработать в конце цепочки");
    }
}
