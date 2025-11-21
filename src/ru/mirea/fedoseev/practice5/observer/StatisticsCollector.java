package ru.mirea.fedoseev.practice5.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * Наблюдатель, который собирает статистику по операциям
 */
public class StatisticsCollector implements StringObserver {
    private Map<String, Integer> operationCounts;
    private int totalOperations;

    public StatisticsCollector() {
        this.operationCounts = new HashMap<>();
        this.totalOperations = 0;
    }

    @Override
    public void onStringChanged(String oldValue, String newValue, String operation) {
        totalOperations++;
        String operationType = operation.split("\\(")[0];
        operationCounts.put(operationType, operationCounts.getOrDefault(operationType, 0) + 1);
    }

    public void printStatistics() {
        System.out.println("\n=== Статистика операций ===");
        System.out.println("Всего операций: " + totalOperations);
        System.out.println("По типам:");
        for (Map.Entry<String, Integer> entry : operationCounts.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getTotalOperations() {
        return totalOperations;
    }
}
