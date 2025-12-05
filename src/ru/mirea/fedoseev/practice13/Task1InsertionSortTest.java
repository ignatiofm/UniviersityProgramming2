package ru.mirea.fedoseev.practice13;

public class Task1InsertionSortTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student(105, "Иван", "Петров", 4.5),
                new Student(101, "Мария", "Иванова", 4.8),
                new Student(103, "Алексей", "Сидоров", 3.9),
                new Student(102, "Елена", "Козлова", 4.2),
                new Student(104, "Дмитрий", "Новиков", 4.0)
        };

        System.out.println("Массив студентов до сортировки:");
        printStudents(students);

        System.out.println("\nСортировка вставками по iDNumber...\n");
        Sorting.insertionSort(students);

        System.out.println("Массив студентов после сортировки по iDNumber:");
        printStudents(students);
    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
