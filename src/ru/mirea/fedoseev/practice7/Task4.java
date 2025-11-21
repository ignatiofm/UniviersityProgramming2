package ru.mirea.fedoseev.practice7;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/**
 * Задание 4. Формирование объектов Date и Calendar по данным пользователя.
 * Формат ввода: <Год><Месяц><Число> <Часы><Минуты>
 */
public class Task4 {
    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.println("Создание объектов Date и Calendar");
        System.out.println(repeatChar('=', 60));
        System.out.println();

        try {
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Введите число (1-31): ");
            int day = scanner.nextInt();

            System.out.print("Введите часы (0-23): ");
            int hours = scanner.nextInt();

            System.out.print("Введите минуты (0-59): ");
            int minutes = scanner.nextInt();

            System.out.println();
            System.out.println(repeatChar('=', 60));
            System.out.println();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day, hours, minutes, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date date = calendar.getTime();

            System.out.println("Созданные объекты:");
            System.out.println();

            System.out.println("1. Объект Calendar:");
            System.out.println("   Год: " + calendar.get(Calendar.YEAR));
            System.out.println("   Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("   День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("   Часы: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("   Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("   День недели: " + getDayOfWeekName(calendar.get(Calendar.DAY_OF_WEEK)));
            System.out.println();

            System.out.println("2. Объект Date:");
            System.out.println("   Форматированная дата: " + dateFormat.format(date));
            System.out.println("   Время в миллисекундах: " + date.getTime());
            System.out.println();

            System.out.println("3. Альтернативный способ создания Date:");
            Date alternativeDate = new Date(year - 1900, month - 1, day, hours, minutes);
            System.out.println("   Форматированная дата: " + dateFormat.format(alternativeDate));
            System.out.println();

            System.out.println("4. Сравнение текущей даты с введенной:");
            Date currentDate = new Date();
            System.out.println("   Текущая дата: " + dateFormat.format(currentDate));
            System.out.println("   Введенная дата: " + dateFormat.format(date));

            if (date.before(currentDate)) {
                long diffMillis = currentDate.getTime() - date.getTime();
                long diffDays = diffMillis / (1000 * 60 * 60 * 24);
                System.out.println("   Введенная дата в прошлом (на " + diffDays + " дней)");
            } else if (date.after(currentDate)) {
                long diffMillis = date.getTime() - currentDate.getTime();
                long diffDays = diffMillis / (1000 * 60 * 60 * 24);
                System.out.println("   Введенная дата в будущем (через " + diffDays + " дней)");
            } else {
                System.out.println("   Введенная дата совпадает с текущей");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: Неверный формат ввода!");
            System.out.println("Убедитесь, что вводите целые числа в правильных диапазонах.");
        } finally {
            scanner.close();
        }

        System.out.println();
        System.out.println(repeatChar('=', 60));
    }

    /**
     * Возвращает название дня недели по номеру.
     */
    private static String getDayOfWeekName(int dayOfWeek) {
        String[] days = {"", "Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
        return days[dayOfWeek];
    }
}
