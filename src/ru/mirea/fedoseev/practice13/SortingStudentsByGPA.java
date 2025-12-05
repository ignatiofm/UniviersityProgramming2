package ru.mirea.fedoseev.practice13;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(105, "Иван", "Петров", 4.5),
                new Student(101, "Мария", "Иванова", 4.8),
                new Student(103, "Алексей", "Сидоров", 3.9),
                new Student(102, "Елена", "Козлова", 4.2),
                new Student(104, "Дмитрий", "Новиков", 4.0),
                new Student(106, "Анна", "Смирнова", 4.9),
                new Student(107, "Павел", "Васильев", 3.5)
        };

        System.out.println("Массив студентов до сортировки:");
        printStudents(students);

        System.out.println("\nБыстрая сортировка (Quick Sort) по GPA в порядке убывания...\n");
        Sorting.quickSort(students, new SortingStudentsByGPA());

        System.out.println("Массив студентов после сортировки по GPA (убывание):");
        printStudents(students);
    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
