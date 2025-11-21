package ru.mirea.fedoseev.task9;

/**
 * Задание 2: Добавление ключевого слова static
 *
 * Правила:
 * - main() должен быть static, так как JVM вызывает его без создания объекта
 * - getCount() НЕ должен быть static, так как возвращает переменную экземпляра count
 * - factorial() МОЖЕТ быть static, так как не использует переменные экземпляра
 *   (но это не обязательно, зависит от логики приложения)
 */
public class Task2 {
    int count;

    // main() ДОЛЖЕН быть static - точка входа в программу
    public static void main(String[] args) {
        Task2 test = new Task2();
        test.count = 5;
        System.out.println("Count: " + test.getCount());
        System.out.println("Factorial of 5: " + test.factorial(5));

        // Также можно вызвать factorial как статический метод
        System.out.println("Factorial of 6: " + factorial(6));
    }

    // getCount() НЕ должен быть static, так как обращается к переменной экземпляра count
    public int getCount() {
        return count;
    }

    // factorial() МОЖЕТ быть static, так как не использует переменные экземпляра
    // Делаем его static, потому что это утилитарный метод
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
}
