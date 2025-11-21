package ru.mirea.fedoseev.practice5.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * StringBuilder с поддержкой паттерна Наблюдатель
 */
public class ObservableStringBuilder {
    private StringBuilder builder;
    private List<StringObserver> observers;

    public ObservableStringBuilder() {
        this.builder = new StringBuilder();
        this.observers = new ArrayList<>();
    }

    public ObservableStringBuilder(String initial) {
        this.builder = new StringBuilder(initial);
        this.observers = new ArrayList<>();
    }

    /**
     * Подписать наблюдателя
     */
    public void addObserver(StringObserver observer) {
        observers.add(observer);
        System.out.println("Наблюдатель подписан: " + observer.getClass().getSimpleName());
    }

    /**
     * Отписать наблюдателя
     */
    public void removeObserver(StringObserver observer) {
        observers.remove(observer);
        System.out.println("Наблюдатель отписан: " + observer.getClass().getSimpleName());
    }

    /**
     * Уведомить всех наблюдателей об изменении
     */
    private void notifyObservers(String oldValue, String operation) {
        String newValue = builder.toString();
        for (StringObserver observer : observers) {
            observer.onStringChanged(oldValue, newValue, operation);
        }
    }

    /**
     * Добавить строку в конец
     */
    public ObservableStringBuilder append(String text) {
        String oldValue = builder.toString();
        builder.append(text);
        notifyObservers(oldValue, "APPEND('" + text + "')");
        return this;
    }

    /**
     * Вставить строку в позицию
     */
    public ObservableStringBuilder insert(int position, String text) {
        String oldValue = builder.toString();
        builder.insert(position, text);
        notifyObservers(oldValue, "INSERT('" + text + "' at " + position + ")");
        return this;
    }

    /**
     * Удалить подстроку
     */
    public ObservableStringBuilder delete(int start, int end) {
        String oldValue = builder.toString();
        String deletedText = builder.substring(start, end);
        builder.delete(start, end);
        notifyObservers(oldValue, "DELETE('" + deletedText + "' from " + start + " to " + end + ")");
        return this;
    }

    /**
     * Заменить подстроку
     */
    public ObservableStringBuilder replace(int start, int end, String text) {
        String oldValue = builder.toString();
        String replacedText = builder.substring(start, end);
        builder.replace(start, end, text);
        notifyObservers(oldValue, "REPLACE('" + replacedText + "' with '" + text + "')");
        return this;
    }

    /**
     * Очистить строку
     */
    public ObservableStringBuilder clear() {
        String oldValue = builder.toString();
        builder.setLength(0);
        notifyObservers(oldValue, "CLEAR()");
        return this;
    }

    /**
     * Получить текущее содержимое
     */
    @Override
    public String toString() {
        return builder.toString();
    }

    /**
     * Получить длину строки
     */
    public int length() {
        return builder.length();
    }

    /**
     * Получить количество наблюдателей
     */
    public int getObserverCount() {
        return observers.size();
    }
}
