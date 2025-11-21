package ru.mirea.fedoseev.practice5;

import java.util.Scanner;

/**
 * Демонстрация работы конвертеров температур
 */
public class TemperatureConverterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Convertable celsiusToKelvin = new CelsiusToKelvin();
        Convertable celsiusToFahrenheit = new CelsiusToFahrenheit();

        System.out.println("=== Конвертер температур ===");
        System.out.print("Введите температуру в градусах Цельсия: ");
        double celsius = scanner.nextDouble();

        double kelvin = celsiusToKelvin.convert(celsius);
        double fahrenheit = celsiusToFahrenheit.convert(celsius);

        System.out.println("\nРезультаты конвертации:");
        System.out.println(celsius + " °C = " + kelvin + " K");
        System.out.println(celsius + " °C = " + fahrenheit + " °F");

        // Демонстрация работы с массивом конвертеров
        System.out.println("\n=== Тестирование различных температур ===");
        double[] testTemperatures = {0, 25, 100, -40, 37};
        Convertable[] converters = {celsiusToKelvin, celsiusToFahrenheit};

        for (double temp : testTemperatures) {
            System.out.println("\nИсходная температура: " + temp + " °C");
            for (Convertable converter : converters) {
                System.out.println("  " + converter + ": " + converter.convert(temp));
            }
        }

        scanner.close();
    }
}
