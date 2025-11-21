package ru.mirea.fedoseev.practice7;

import java.util.Date;
import java.util.Calendar;

/**
 * Задание 3. Тестовый класс для демонстрации работы класса Student
 * с различными форматами даты рождения.
 */
public class Task3 {
    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.MARCH, 15);
        Date birthDate = calendar.getTime();

        Student student = new Student("Федосеев Игнат", birthDate, 12345);

        System.out.println("Демонстрация различных форматов даты рождения студента");
        System.out.println(repeatChar('=', 60));
        System.out.println();

        System.out.println("Краткий формат (SHORT):");
        System.out.println(student.toString("SHORT"));
        System.out.println();

        System.out.println("Средний формат (MEDIUM):");
        System.out.println(student.toString("MEDIUM"));
        System.out.println();

        System.out.println("Полный формат (LONG):");
        System.out.println(student.toString("LONG"));
        System.out.println();

        System.out.println("Формат по умолчанию (toString()):");
        System.out.println(student.toString());
        System.out.println();

        System.out.println("Только дата рождения (SHORT): " + student.getBirthDateFormatted("SHORT"));
        System.out.println("Только дата рождения (MEDIUM): " + student.getBirthDateFormatted("MEDIUM"));
        System.out.println("Только дата рождения (LONG): " + student.getBirthDateFormatted("LONG"));

        System.out.println();
        System.out.println(repeatChar('=', 60));
    }
}
