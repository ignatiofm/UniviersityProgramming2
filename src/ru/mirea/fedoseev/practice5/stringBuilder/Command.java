package ru.mirea.fedoseev.practice5.stringBuilder;

/**
 * Интерфейс команды для паттерна Команда
 */
public interface Command {
    void execute();
    void undo();
}
