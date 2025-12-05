package ru.mirea.fedoseev.practice12;

import java.util.Scanner;

public class ThrowsDemo4 {

    private Scanner myScanner = new Scanner(System.in);

    public void getKey() {
        boolean success = false;

        while (!success) {
            System.out.print("Enter key (non-empty string, or 'exit' to quit): ");
            String key = myScanner.nextLine();

            if (key.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы");
                return;
            }

            try {
                printDetails(key);
                success = true;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Попробуйте еще раз.\n");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println("Результат: " + message);
    }

    private String getDetails(String key) throws Exception {
        if (key == null || key.trim().isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for '" + key + "'";
    }

    public void getKeyWithLimit(int maxAttempts) {
        int attempts = 0;

        while (attempts < maxAttempts) {
            attempts++;
            System.out.print("Попытка " + attempts + "/" + maxAttempts + ". Enter key: ");
            String key = myScanner.nextLine();

            try {
                printDetails(key);
                System.out.println("Успех!");
                return;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                if (attempts < maxAttempts) {
                    System.out.println("Осталось попыток: " + (maxAttempts - attempts) + "\n");
                }
            }
        }

        System.out.println("Превышено максимальное количество попыток!");
    }

    public static void main(String[] args) {
        ThrowsDemo4 demo = new ThrowsDemo4();

        System.out.println("=== Задание 8: Повторный ввод при ошибке ===\n");

        System.out.println("--- Вариант 1: Бесконечный цикл до успеха ---");
        System.out.println("(введите 'exit' для выхода или пустую строку для ошибки)");
        demo.getKey();

        System.out.println("\n--- Вариант 2: Ограниченное количество попыток ---");
        demo.getKeyWithLimit(3);

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. throw прекращает выполнение метода (как return)");
        System.out.println("2. Без catch - исключение 'ломает' весь стек вызовов");
        System.out.println("3. С catch - можно перехватить и продолжить выполнение");
        System.out.println("4. Цикл while + try-catch = повторный ввод при ошибке");
        System.out.println("5. Флаг success или return управляют выходом из цикла");
        System.out.println("\n=== Иерархия операторов прекращения выполнения ===");
        System.out.println("continue - прекращает текущую итерацию цикла");
        System.out.println("break    - прекращает выполнение блока (цикла)");
        System.out.println("return   - прекращает выполнение метода");
        System.out.println("throw    - прекращает выполнение всего стека (до catch)");
    }
}
