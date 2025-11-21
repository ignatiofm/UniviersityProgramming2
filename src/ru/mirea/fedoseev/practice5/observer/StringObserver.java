package ru.mirea.fedoseev.practice5.observer;

/**
 * Интерфейс наблюдателя для отслеживания изменений строки
 */
public interface StringObserver {
    void onStringChanged(String oldValue, String newValue, String operation);
}
