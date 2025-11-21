package ru.mirea.fedoseev.practice5.observer;

/**
 * Наблюдатель, который отслеживает изменение длины строки
 */
public class LengthTracker implements StringObserver {
    private int totalChanges = 0;

    @Override
    public void onStringChanged(String oldValue, String newValue, String operation) {
        totalChanges++;
        int oldLength = oldValue.length();
        int newLength = newValue.length();
        int diff = newLength - oldLength;

        System.out.println("[LengthTracker] Изменение #" + totalChanges);
        System.out.println("[LengthTracker] Длина: " + oldLength + " -> " + newLength +
                         " (изменение: " + (diff >= 0 ? "+" : "") + diff + ")");
        System.out.println();
    }

    public int getTotalChanges() {
        return totalChanges;
    }
}
