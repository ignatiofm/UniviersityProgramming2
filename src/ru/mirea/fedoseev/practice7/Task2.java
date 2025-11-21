package ru.mirea.fedoseev.practice7;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Задание 2. Приложение, сравнивающее текущую дату
 * и дату, введенную пользователем с текущим системным временем.
 */
public class Task2 {
    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Сравнение дат");
        System.out.println(repeatChar('=', 50));

        Date currentDate = new Date();
        System.out.println("Текущая дата и время: " + dateFormat.format(currentDate));
        System.out.println();

        System.out.println("Введите дату и время в формате dd.MM.yyyy HH:mm:ss");
        System.out.print("Пример: 15.03.2024 14:30:00: ");

        try {
            String userInput = scanner.nextLine();
            Date userDate = dateFormat.parse(userInput);

            System.out.println();
            System.out.println("Введенная дата: " + dateFormat.format(userDate));
            System.out.println();

            if (userDate.before(currentDate)) {
                System.out.println("Результат: Введенная дата РАНЬШЕ текущей даты");
                long diffMillis = currentDate.getTime() - userDate.getTime();
                long diffDays = diffMillis / (1000 * 60 * 60 * 24);
                System.out.println("Разница: " + diffDays + " дней назад");
            } else if (userDate.after(currentDate)) {
                System.out.println("Результат: Введенная дата ПОЗЖЕ текущей даты");
                long diffMillis = userDate.getTime() - currentDate.getTime();
                long diffDays = diffMillis / (1000 * 60 * 60 * 24);
                System.out.println("Разница: через " + diffDays + " дней");
            } else {
                System.out.println("Результат: Введенная дата СОВПАДАЕТ с текущей датой");
            }

            System.out.println();
            System.out.println("Сравнение через compareTo:");
            int comparison = currentDate.compareTo(userDate);
            if (comparison > 0) {
                System.out.println("Текущая дата позже введенной");
            } else if (comparison < 0) {
                System.out.println("Текущая дата раньше введенной");
            } else {
                System.out.println("Даты равны");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты!");
            System.out.println("Используйте формат: dd.MM.yyyy HH:mm:ss");
        } finally {
            scanner.close();
        }

        System.out.println(repeatChar('=', 50));
    }
}
