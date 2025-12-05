package ru.mirea.fedoseev.practice15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task4AppendToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла для добавления текста:");
        String fileName = scanner.nextLine();

        System.out.println("\nТекущее содержимое файла:");
        System.out.println("----------------------------------------");
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println("Файл не существует, будет создан новый.");
        }
        System.out.println("----------------------------------------");

        System.out.println("\nВведите текст для добавления в конец файла (для завершения введите пустую строку):");
        StringBuilder appendText = new StringBuilder();

        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            appendText.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(appendText.toString());
            System.out.println("Текст успешно добавлен в конец файла!");

            System.out.println("\nОбновлённое содержимое файла:");
            System.out.println("----------------------------------------");
            try (FileReader reader = new FileReader(fileName)) {
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }
            System.out.println("----------------------------------------");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}
