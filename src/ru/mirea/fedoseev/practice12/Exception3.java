package ru.mirea.fedoseev.practice12;

import java.util.Scanner;

public class Exception3 {

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
        }
    }

    public void exceptionDemoGeneralOnly() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println("Result: " + (2 / i));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getClass().getSimpleName()
                    + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Exception3 demo = new Exception3();

        System.out.println("=== Задание 3: Порядок catch-блоков ===");
        System.out.println("Возможные входные данные для тестирования:");
        System.out.println("  'Qwerty' -> NumberFormatException");
        System.out.println("  '0'      -> ArithmeticException");
        System.out.println("  '1'      -> Успешно (результат: 2)");
        System.out.println();

        System.out.println("--- Правильный порядок catch (специфичные -> общие) ---");
        demo.exceptionDemo();

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. catch-блоки проверяются в порядке их объявления");
        System.out.println("2. Exception - родительский класс для всех исключений");
        System.out.println("3. Если Exception стоит первым, он перехватит ВСЕ исключения");
        System.out.println("4. Правильный порядок: от более специфичных к более общим");
    }
}
