package ru.mirea.fedoseev.practice5.stringBuilder;

/**
 * Демонстрация работы UndoableStringBuilder
 */
public class UndoableStringBuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация UndoableStringBuilder с паттерном Команда ===\n");

        UndoableStringBuilder sb = new UndoableStringBuilder();

        // Операция 1: Append
        System.out.println("1. Добавляем 'Hello'");
        sb.append("Hello");
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Операция 2: Append
        System.out.println("2. Добавляем ' World'");
        sb.append(" World");
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Операция 3: Insert
        System.out.println("3. Вставляем ' Beautiful' в позицию 5");
        sb.insert(5, " Beautiful");
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Операция 4: Append
        System.out.println("4. Добавляем '!'");
        sb.append("!");
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Отмена операции 4
        System.out.println("5. Отменяем последнюю операцию (append '!')");
        sb.undo();
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Отмена операции 3
        System.out.println("6. Отменяем последнюю операцию (insert ' Beautiful')");
        sb.undo();
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Операция 5: Delete
        System.out.println("7. Удаляем символы с 5 по 11 (слово 'World')");
        sb.delete(5, 11);
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Отмена операции 5
        System.out.println("8. Отменяем последнюю операцию (delete 'World')");
        sb.undo();
        System.out.println("   Результат: '" + sb + "'");
        System.out.println("   История: " + sb.getHistorySize() + " операций\n");

        // Отменяем все оставшиеся операции
        System.out.println("9. Отменяем все оставшиеся операции:");
        while (sb.undo()) {
            System.out.println("   Результат: '" + sb + "'");
        }

        System.out.println("\n=== Демонстрация цепочки операций ===\n");
        UndoableStringBuilder sb2 = new UndoableStringBuilder("Start");
        System.out.println("Исходная строка: '" + sb2 + "'");

        sb2.append(" -> ").append("Step1").append(" -> ").append("Step2");
        System.out.println("После цепочки append: '" + sb2 + "'");
        System.out.println("Операций в истории: " + sb2.getHistorySize());

        System.out.println("\nОтменяем 2 операции:");
        sb2.undo();
        System.out.println("  Результат: '" + sb2 + "'");
        sb2.undo();
        System.out.println("  Результат: '" + sb2 + "'");
    }
}
