package ru.mirea.fedoseev.practice12;

import java.util.Scanner;

public class Exception4 {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println("Result: " + (2 / i));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Введенное значение '" + intString
                    + "' не является целым числом");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Деление на ноль невозможно");
        } catch (Exception e) {
            System.out.println("Exception: Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println(">>> Блок finally выполнен <<<");
            System.out.println(">>> Здесь обычно освобождаются ресурсы <<<");
        }
    }

    public void demonstrateFinallyOnSuccess() {
        System.out.println("\n--- Демонстрация finally при успешном выполнении ---");
        try {
            System.out.println("Выполнение try-блока...");
            int result = 10 / 2;
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Catch-блок (не будет вызван)");
        } finally {
            System.out.println("Finally-блок выполнен (после успешного try)");
        }
    }

    public void demonstrateFinallyOnException() {
        System.out.println("\n--- Демонстрация finally при исключении ---");
        try {
            System.out.println("Выполнение try-блока...");
            int result = 10 / 0;
            System.out.println("Этот код не выполнится");
        } catch (ArithmeticException e) {
            System.out.println("Catch-блок: перехвачено исключение");
        } finally {
            System.out.println("Finally-блок выполнен (после catch)");
        }
    }

    public int demonstrateFinallyWithReturn() {
        System.out.println("\n--- Демонстрация finally с return ---");
        try {
            System.out.println("Выполнение try-блока с return...");
            return 42;
        } finally {
            System.out.println("Finally-блок выполнен (перед return)");
        }
    }

    public static void main(String[] args) {
        Exception4 demo = new Exception4();

        System.out.println("=== Задание 4: Блок finally ===");
        System.out.println("Возможные входные данные для тестирования:");
        System.out.println("  'Qwerty' -> NumberFormatException + finally");
        System.out.println("  '0'      -> ArithmeticException + finally");
        System.out.println("  '1'      -> Успешно + finally");
        System.out.println();

        demo.exceptionDemo();

        demo.demonstrateFinallyOnSuccess();
        demo.demonstrateFinallyOnException();

        int result = demo.demonstrateFinallyWithReturn();
        System.out.println("Возвращенное значение: " + result);

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. Блок finally выполняется ВСЕГДА");
        System.out.println("2. Даже если в try есть return - finally выполнится перед возвратом");
        System.out.println("3. finally используется для гарантированного освобождения ресурсов");
        System.out.println("4. Например: закрытие файлов, соединений с БД, освобождение памяти");
    }
}
