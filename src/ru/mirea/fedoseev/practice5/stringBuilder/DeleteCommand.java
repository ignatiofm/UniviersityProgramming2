package ru.mirea.fedoseev.practice5.stringBuilder;

/**
 * Команда удаления подстроки
 */
public class DeleteCommand implements Command {
    private StringBuilder target;
    private int start;
    private int end;
    private String deletedText;

    public DeleteCommand(StringBuilder target, int start, int end) {
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        deletedText = target.substring(start, end);
        target.delete(start, end);
    }

    @Override
    public void undo() {
        target.insert(start, deletedText);
    }

    @Override
    public String toString() {
        return "Delete: from " + start + " to " + end + " ('" + deletedText + "')";
    }
}
