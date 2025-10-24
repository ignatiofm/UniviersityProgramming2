package ru.mirea.fedoseev.practice41.task3;

public class PersonTester {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Иванов Иван Иванович", 25);

        System.out.println("=== Информация о людях ===");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println();

        System.out.println("=== Вызов методов ===");
        person1.move();
        person1.talk();
        System.out.println();

        person2.move();
        person2.talk();
    }
}
