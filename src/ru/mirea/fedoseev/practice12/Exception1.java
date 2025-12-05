package ru.mirea.fedoseev.practice12;

public class Exception1 {

    public void exceptionDemoOriginal() {
        System.out.println("=== Шаг 1: Деление целых чисел на ноль ===");
        System.out.println(2 / 0);
    }

    public void exceptionDemoDouble() {
        System.out.println("=== Шаг 2: Деление чисел с плавающей точкой на ноль ===");
        System.out.println("2.0 / 0.0 = " + (2.0 / 0.0));
        System.out.println("-2.0 / 0.0 = " + (-2.0 / 0.0));
        System.out.println("0.0 / 0.0 = " + (0.0 / 0.0));
    }

    public void exceptionDemo() {
        System.out.println("=== Шаг 3: Деление с обработкой исключения ===");
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 demo = new Exception1();

        demo.exceptionDemoDouble();
        System.out.println();

        demo.exceptionDemo();
        System.out.println();

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("Шаг 1: Деление целых чисел на ноль вызывает ArithmeticException");
        System.out.println("Шаг 2: Деление double на ноль возвращает Infinity (по стандарту IEEE 754)");
        System.out.println("Шаг 3: try-catch перехватывает исключение и позволяет продолжить выполнение");
    }
}
