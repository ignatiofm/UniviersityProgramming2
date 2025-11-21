package ru.mirea.fedoseev.practice7;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Задание 1. Программа, выводящая фамилию разработчика,
 * дату и время получения задания, а также дату и время сдачи задания.
 */
public class Task1 {
    private String developerLastName;
    private Date taskReceivedDate;
    private Date taskSubmittedDate;

    public Task1(String developerLastName) {
        this.developerLastName = developerLastName;
        this.taskReceivedDate = new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000);
        this.taskSubmittedDate = new Date();
    }

    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println(repeatChar('=', 50));
        System.out.println("Информация о задании");
        System.out.println(repeatChar('=', 50));
        System.out.println("Фамилия разработчика: " + developerLastName);
        System.out.println("Дата и время получения задания: " + dateFormat.format(taskReceivedDate));
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(taskSubmittedDate));
        System.out.println(repeatChar('=', 50));
    }

    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Task1 task = new Task1("Федосеев");
        task.displayInfo();
    }
}
