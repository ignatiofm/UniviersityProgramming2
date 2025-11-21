package ru.mirea.fedoseev.practice5.stringBuilder;

import java.util.Stack;

/**
 * StringBuilder с поддержкой отмены операций
 */
public class UndoableStringBuilder {
    private StringBuilder builder;
    private Stack<Command> history;

    public UndoableStringBuilder() {
        this.builder = new StringBuilder();
        this.history = new Stack<>();
    }

    public UndoableStringBuilder(String initial) {
        this.builder = new StringBuilder(initial);
        this.history = new Stack<>();
    }

    /**
     * Добавить строку в конец
     */
    public UndoableStringBuilder append(String text) {
        Command cmd = new AppendCommand(builder, text);
        cmd.execute();
        history.push(cmd);
        return this;
    }

    /**
     * Удалить подстроку
     */
    public UndoableStringBuilder delete(int start, int end) {
        Command cmd = new DeleteCommand(builder, start, end);
        cmd.execute();
        history.push(cmd);
        return this;
    }

    /**
     * Вставить строку в позицию
     */
    public UndoableStringBuilder insert(int position, String text) {
        Command cmd = new InsertCommand(builder, position, text);
        cmd.execute();
        history.push(cmd);
        return this;
    }

    /**
     * Отменить последнюю операцию
     */
    public boolean undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
            System.out.println("Отменена операция: " + cmd);
            return true;
        }
        System.out.println("Нет операций для отмены");
        return false;
    }

    /**
     * Получить текущее содержимое
     */
    @Override
    public String toString() {
        return builder.toString();
    }

    /**
     * Получить количество операций в истории
     */
    public int getHistorySize() {
        return history.size();
    }

    /**
     * Очистить историю
     */
    public void clearHistory() {
        history.clear();
    }

    /**
     * Получить длину строки
     */
    public int length() {
        return builder.length();
    }
}
