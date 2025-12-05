package ru.mirea.fedoseev.practice12;

public class ThrowsDemo2 {

    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public void printMessageSafe(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: невозможно получить данные - " + e.getMessage());
            System.out.println("Пожалуйста, укажите корректный ключ");
        }
    }

    public static void main(String[] args) {
        ThrowsDemo2 demo = new ThrowsDemo2();

        System.out.println("=== Задание 6: Проброс исключений через цепочку вызовов ===\n");

        System.out.println("--- Вызов printMessage с нормальным значением ---");
        demo.printMessage("myKey");

        System.out.println("\n--- Вызов printMessageSafe с null ---");
        demo.printMessageSafe(null);

        System.out.println("\n--- Вызов printMessageSafe с нормальным значением ---");
        demo.printMessageSafe("anotherKey");

        System.out.println("\n--- Вызов printMessage с null (перехват в main) ---");
        try {
            demo.printMessage(null);
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в main:");
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Стек вызовов:");
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().contains("ThrowsDemo2")) {
                    System.out.println("    at " + element);
                }
            }
        }

        System.out.println("\n=== Объяснение поведения ===");
        System.out.println("1. getDetails() выбрасывает NullPointerException при null");
        System.out.println("2. Если printMessage() не обрабатывает исключение - оно пробрасывается выше");
        System.out.println("3. Стек вызовов показывает путь исключения:");
        System.out.println("   main() -> printMessage() -> getDetails()");
        System.out.println("4. printMessageSafe() обрабатывает исключение и не дает ему пробраситься");
    }
}
