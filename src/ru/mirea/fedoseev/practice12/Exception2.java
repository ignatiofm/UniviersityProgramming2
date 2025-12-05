package ru.mirea.fedoseev.practice12;

import java.util.Scanner;

public class Exception2 {

    public void exceptionDemoOriginal() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }

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
        }
    }

    public static void main(String[] args) {
        Exception2 demo = new Exception2();

        System.out.println("=== Задание 2: Обработка исключений при вводе ===");
        System.out.println("Возможные входные данные для тестирования:");
        System.out.println("  'Qwerty' -> NumberFormatException");
        System.out.println("  '0'      -> ArithmeticException");
        System.out.println("  '1.2'    -> NumberFormatException");
        System.out.println("  '1'      -> Успешно (результат: 2)");
        System.out.println();

        demo.exceptionDemo();

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("NumberFormatException - строка не может быть преобразована в целое число");
        System.out.println("ArithmeticException - попытка деления на ноль");
    }
}
