package ru.mirea.fedoseev.practice12;

public class ThrowsDemo1 {

    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("Processing key: " + key);
    }

    public void getDetailsWithTryCatch(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("Processing key: " + key);
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Подсказка: передайте непустой ключ");
        }
    }

    public static void main(String[] args) {
        ThrowsDemo1 demo = new ThrowsDemo1();

        System.out.println("=== Задание 5: Генерация исключений (throw) ===\n");

        System.out.println("--- Вызов getDetails с нормальным значением ---");
        demo.getDetails("myKey");

        System.out. println("\n--- Вызов getDetailsWithTryCatch с null ---");
        demo.getDetailsWithTryCatch(null);

        System.out.println("\n--- Вызов getDetailsWithTryCatch с нормальным значением ---");
        demo.getDetailsWithTryCatch("anotherKey");

        System.out.println("\n--- Вызов getDetails с null (без обработки) ---");
        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в main: " + e.getMessage());
        }

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. throw создает и выбрасывает новое исключение");
        System.out.println("2. NullPointerException - unchecked, не требует throws в сигнатуре");
        System.out.println("3. Обработка внутри метода не всегда уместна");
        System.out.println("4. Лучше позволить вызывающему коду решить, как обработать ошибку");
        System.out.println("5. Причина ошибки (неправильный параметр) должна решаться вызывающим кодом");
    }
}
