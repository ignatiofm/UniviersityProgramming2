package ru.mirea.fedoseev.practice5.observer;

/**
 * Наблюдатель, который логирует изменения в консоль
 */
public class ConsoleLogger implements StringObserver {
    private String name;

    public ConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public void onStringChanged(String oldValue, String newValue, String operation) {
        System.out.println("[" + name + "] Операция: " + operation);
        System.out.println("[" + name + "] Было: '" + oldValue + "'");
        System.out.println("[" + name + "] Стало: '" + newValue + "'");
        System.out.println();
    }
}
