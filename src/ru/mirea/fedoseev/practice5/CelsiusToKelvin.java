package ru.mirea.fedoseev.practice5;

/**
 * Конвертер температуры из Цельсия в Кельвины
 */
public class CelsiusToKelvin implements Convertable {

    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }

    @Override
    public String toString() {
        return "Celsius → Kelvin converter";
    }
}
