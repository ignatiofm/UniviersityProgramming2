package ru.mirea.fedoseev.practice6;

public class ProcessStrings implements Stringable {

    @Override
    public int countCharacters(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    @Override
    public String getOddPositionCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        // Позиции 1, 3, 5, ... (индексы 0, 2, 4, ...)
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String invertString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        return new StringBuilder(s).reverse().toString();
    }
}
