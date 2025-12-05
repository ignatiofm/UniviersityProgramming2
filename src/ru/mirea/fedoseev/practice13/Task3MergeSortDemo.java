package ru.mirea.fedoseev.practice13;

public class Task3MergeSortDemo {
    public static void main(String[] args) {
        Student[] list1 = {
                new Student(105, "Иван", "Петров", 4.5),
                new Student(101, "Мария", "Иванова", 4.8),
                new Student(103, "Алексей", "Сидоров", 3.9)
        };

        Student[] list2 = {
                new Student(102, "Елена", "Козлова", 4.2),
                new Student(104, "Дмитрий", "Новиков", 4.0),
                new Student(106, "Анна", "Смирнова", 4.9),
                new Student(100, "Павел", "Васильев", 3.5)
        };

        System.out.println("Первый список студентов (до сортировки):");
        printStudents(list1);

        System.out.println("\nВторой список студентов (до сортировки):");
        printStudents(list2);

        System.out.println("\n--- Сортировка слиянием (Merge Sort) каждого списка ---\n");
        Sorting.mergeSort(list1);
        Sorting.mergeSort(list2);

        System.out.println("Первый список после Merge Sort:");
        printStudents(list1);

        System.out.println("\nВторой список после Merge Sort:");
        printStudents(list2);

        System.out.println("\n--- Объединение двух отсортированных списков ---\n");
        Student[] mergedList = new Student[list1.length + list2.length];
        Sorting.mergeTwoSortedArrays(list1, list2, mergedList);

        System.out.println("Объединённый отсортированный список:");
        printStudents(mergedList);
    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
