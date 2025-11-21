package ru.mirea.fedoseev.practice5.stringBuilder;

/**
 * Команда добавления строки
 */
public class AppendCommand implements Command {
    private StringBuilder target;
    private String text;
    private int startPosition;

    public AppendCommand(StringBuilder target, String text) {
        this.target = target;
        this.text = text;
    }

    @Override
    public void execute() {
        startPosition = target.length();
        target.append(text);
    }

    @Override
    public void undo() {
        target.delete(startPosition, target.length());
    }

    @Override
    public String toString() {
        return "Append: '" + text + "'";
    }
}
