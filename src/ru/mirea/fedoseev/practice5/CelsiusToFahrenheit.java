package ru.mirea.fedoseev.practice5;

/**
 * Конвертер температуры из Цельсия в Фаренгейты
 */
public class CelsiusToFahrenheit implements Convertable {

    @Override
    public double convert(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    @Override
    public String toString() {
        return "Celsius → Fahrenheit converter";
    }
}
