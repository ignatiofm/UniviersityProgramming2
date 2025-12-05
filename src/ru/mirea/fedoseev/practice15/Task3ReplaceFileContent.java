package ru.mirea.fedoseev.practice15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3ReplaceFileContent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла для замены содержимого:");
        String fileName = scanner.nextLine();

        System.out.println("\nТекущее содержимое файла:");
        System.out.println("----------------------------------------");
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println("Файл не существует или не может быть прочитан: " + ex.getMessage());
        }
        System.out.println("----------------------------------------");

        System.out.println("\nВведите новый текст для замены (для завершения введите пустую строку):");
        StringBuilder newText = new StringBuilder();

        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            newText.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(newText.toString());
            System.out.println("Содержимое файла успешно заменено!");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}
