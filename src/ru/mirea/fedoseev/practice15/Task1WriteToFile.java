package ru.mirea.fedoseev.practice15;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла для записи:");
        String fileName = scanner.nextLine();

        System.out.println("Введите текст для записи в файл (для завершения введите пустую строку):");
        StringBuilder text = new StringBuilder();

        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            text.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(text.toString());
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}
