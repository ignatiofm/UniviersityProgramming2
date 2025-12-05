package ru.mirea.fedoseev.practice15;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2ReadFromFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла для чтения:");
        String fileName = scanner.nextLine();

        System.out.println("\nСодержимое файла " + fileName + ":");
        System.out.println("----------------------------------------");

        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("----------------------------------------");
        } catch (IOException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
        }

        scanner.close();
    }
}
