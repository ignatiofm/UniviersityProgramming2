package ru.mirea.fedoseev.practice41.task2;

public class PhoneTester {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+7-900-123-45-67", "iPhone 14", 172.0);
        Phone phone2 = new Phone("+7-911-234-56-78", "Samsung Galaxy S23", 168.0);
        Phone phone3 = new Phone("+7-922-345-67-89", "Xiaomi 13");

        System.out.println("=== Информация о телефонах ===");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.println();

        System.out.println("=== Тестирование метода receiveCall ===");
        phone1.receiveCall("Иван");
        phone2.receiveCall("Мария");
        phone3.receiveCall("Петр");
        System.out.println();

        System.out.println("=== Тестирование метода getNumber ===");
        System.out.println("Номер телефона 1: " + phone1.getNumber());
        System.out.println("Номер телефона 2: " + phone2.getNumber());
        System.out.println("Номер телефона 3: " + phone3.getNumber());
        System.out.println();

        System.out.println("=== Тестирование перегруженного метода receiveCall ===");
        phone1.receiveCall("Анна", "+7-933-111-22-33");
        phone2.receiveCall("Дмитрий", "+7-944-222-33-44");
        System.out.println();

        System.out.println("=== Тестирование метода sendMessage ===");
        phone1.sendMessage("+7-900-111-11-11", "+7-911-222-22-22", "+7-922-333-33-33");
        System.out.println();

        phone2.sendMessage("+7-933-444-44-44", "+7-944-555-55-55");
        System.out.println();

        System.out.println("=== Демонстрация различных конструкторов ===");
        Phone phone4 = new Phone();
        Phone phone5 = new Phone("+7-955-666-66-66", "Nokia 3310");
        Phone phone6 = new Phone("+7-966-777-77-77", "OnePlus 11", 205.0);

        System.out.println(phone4);
        System.out.println(phone5);
        System.out.println(phone6);
    }
}
