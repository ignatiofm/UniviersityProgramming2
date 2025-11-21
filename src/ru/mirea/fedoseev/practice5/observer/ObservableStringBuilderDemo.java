package ru.mirea.fedoseev.practice5.observer;

/**
 * Демонстрация работы ObservableStringBuilder с паттерном Наблюдатель
 */
public class ObservableStringBuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация ObservableStringBuilder с паттерном Наблюдатель ===\n");

        // Создаем наблюдаемый объект
        ObservableStringBuilder sb = new ObservableStringBuilder();

        // Создаем и подписываем наблюдателей
        ConsoleLogger logger = new ConsoleLogger("Logger");
        LengthTracker lengthTracker = new LengthTracker();
        StatisticsCollector stats = new StatisticsCollector();

        sb.addObserver(logger);
        sb.addObserver(lengthTracker);
        sb.addObserver(stats);

        System.out.println("\nВсего наблюдателей: " + sb.getObserverCount());
        System.out.println("\n============================================================\n");

        // Выполняем различные операции
        System.out.println(">>> Операция 1: Append 'Hello'");
        sb.append("Hello");

        System.out.println(">>> Операция 2: Append ' World'");
        sb.append(" World");

        System.out.println(">>> Операция 3: Insert 'Beautiful ' в позицию 6");
        sb.insert(6, "Beautiful ");

        System.out.println(">>> Операция 4: Delete с 6 по 16");
        sb.delete(6, 16);

        System.out.println(">>> Операция 5: Replace 'World' на 'Java'");
        sb.replace(6, 11, "Java");

        System.out.println(">>> Операция 6: Append '!'");
        sb.append("!");

        // Отписываем один наблюдатель
        System.out.println("\n============================================================");
        sb.removeObserver(logger);
        System.out.println("Осталось наблюдателей: " + sb.getObserverCount());
        System.out.println("============================================================\n");

        System.out.println(">>> Операция 7: Append ' Programming'");
        sb.append(" Programming");

        // Финальное состояние
        System.out.println("============================================================");
        System.out.println("\nФинальная строка: '" + sb + "'");
        System.out.println("Длина: " + sb.length());

        // Статистика
        stats.printStatistics();

        // Демонстрация очистки
        System.out.println("\n============================================================");
        System.out.println(">>> Операция 8: Clear");
        sb.clear();
        System.out.println("Финальная строка после очистки: '" + sb + "'");
    }
}
