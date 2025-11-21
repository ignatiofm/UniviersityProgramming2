package ru.mirea.fedoseev.task9;

/**
 * Задание 1: Анализ допустимости выражений
 *
 * Класс F:
 * - int i (переменная экземпляра)
 * - static String s (статическая переменная)
 * - void imethod() (метод экземпляра)
 * - static void smethod() (статический метод)
 *
 * f - объект типа F
 */
public class Task1 {
    public static void main(String[] args) {
        F f = new F();

        // 1. System.out.println(f.i);
        // ДОПУСТИМО - доступ к переменной экземпляра через объект
        System.out.println("1. f.i = " + f.i);

        // 2. System.out.println(f.s);
        // ДОПУСТИМО (но не рекомендуется) - доступ к статической переменной через объект
        // Компилятор выдаст предупреждение, но код скомпилируется
        System.out.println("2. f.s = " + f.s);

        // 3. f.imethod();
        // ДОПУСТИМО - вызов метода экземпляра через объект
        System.out.print("3. ");
        f.imethod();

        // 4. f.smethod();
        // ДОПУСТИМО (но не рекомендуется) - вызов статического метода через объект
        // Компилятор выдаст предупреждение, но код скомпилируется
        System.out.print("4. ");
        f.smethod();

        // 5. System.out.println(F.i);
        // НЕ ДОПУСТИМО - нельзя получить доступ к переменной экземпляра через класс
        // System.out.println("5. F.i = " + F.i); // Ошибка компиляции!
        System.out.println("5. F.i - НЕ ДОПУСТИМО (ошибка компиляции)");

        // 6. System.out.println(F.s);
        // ДОПУСТИМО - правильный способ доступа к статической переменной через класс
        System.out.println("6. F.s = " + F.s);

        // 7. F.imethod();
        // НЕ ДОПУСТИМО - нельзя вызвать метод экземпляра через класс
        // System.out.print("7. ");
        // F.imethod(); // Ошибка компиляции!
        System.out.println("7. F.imethod() - НЕ ДОПУСТИМО (ошибка компиляции)");

        // 8. F.smethod();
        // ДОПУСТИМО - правильный способ вызова статического метода через класс
        System.out.print("8. ");
        F.smethod();

        System.out.println("\nИтог:");
        System.out.println("Допустимые выражения: 1, 2, 3, 4, 6, 8");
        System.out.println("Недопустимые выражения: 5, 7");
    }
}

class F {
    int i = 10;
    static String s = "static string";

    void imethod() {
        System.out.println("Вызван метод экземпляра imethod()");
    }

    static void smethod() {
        System.out.println("Вызван статический метод smethod()");
    }
}
