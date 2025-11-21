package ru.mirea.fedoseev.practice5.stringBuilder;

/**
 * Команда вставки строки в определенную позицию
 */
public class InsertCommand implements Command {
    private StringBuilder target;
    private int position;
    private String text;

    public InsertCommand(StringBuilder target, int position, String text) {
        this.target = target;
        this.position = position;
        this.text = text;
    }

    @Override
    public void execute() {
        target.insert(position, text);
    }

    @Override
    public void undo() {
        target.delete(position, position + text.length());
    }

    @Override
    public String toString() {
        return "Insert: '" + text + "' at position " + position;
    }
}
