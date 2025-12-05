package ru.mirea.fedoseev.practice13;

import java.util.Comparator;

public class Task4ComparableDemo {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Война и мир", "Л.Н. Толстой", 1869, 850.0),
                new Book("Преступление и наказание", "Ф.М. Достоевский", 1866, 650.0),
                new Book("Мастер и Маргарита", "М.А. Булгаков", 1967, 720.0),
                new Book("Евгений Онегин", "А.С. Пушкин", 1833, 450.0),
                new Book("Мёртвые души", "Н.В. Гоголь", 1842, 520.0),
                new Book("Отцы и дети", "И.С. Тургенев", 1862, 480.0)
        };

        System.out.println("=== Сортировка книг с использованием Comparable ===\n");

        System.out.println("Книги до сортировки:");
        printBooks(books);

        System.out.println("\nСортировка вставками по году издания (Comparable)...\n");
        Sorting.insertionSort(books);

        System.out.println("Книги после сортировки по году издания:");
        printBooks(books);

        System.out.println("\n=== Сортировка книг с использованием Comparator ===\n");

        Book[] books2 = {
                new Book("Война и мир", "Л.Н. Толстой", 1869, 850.0),
                new Book("Преступление и наказание", "Ф.М. Достоевский", 1866, 650.0),
                new Book("Мастер и Маргарита", "М.А. Булгаков", 1967, 720.0),
                new Book("Евгений Онегин", "А.С. Пушкин", 1833, 450.0),
                new Book("Мёртвые души", "Н.В. Гоголь", 1842, 520.0),
                new Book("Отцы и дети", "И.С. Тургенев", 1862, 480.0)
        };

        System.out.println("Книги до сортировки:");
        printBooks(books2);

        System.out.println("\nБыстрая сортировка по цене (убывание) с Comparator...\n");
        Sorting.quickSort(books2, new BookPriceComparator());

        System.out.println("Книги после сортировки по цене (убывание):");
        printBooks(books2);

        System.out.println("\n=== Сортировка книг с использованием Merge Sort ===\n");

        Book[] books3 = {
                new Book("Война и мир", "Л.Н. Толстой", 1869, 850.0),
                new Book("Преступление и наказание", "Ф.М. Достоевский", 1866, 650.0),
                new Book("Мастер и Маргарита", "М.А. Булгаков", 1967, 720.0),
                new Book("Евгений Онегин", "А.С. Пушкин", 1833, 450.0)
        };

        System.out.println("Книги до сортировки:");
        printBooks(books3);

        System.out.println("\nСортировка слиянием по году издания (Comparable)...\n");
        Sorting.mergeSort(books3);

        System.out.println("Книги после Merge Sort по году издания:");
        printBooks(books3);
    }

    private static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Double.compare(b2.getPrice(), b1.getPrice());
    }
}
