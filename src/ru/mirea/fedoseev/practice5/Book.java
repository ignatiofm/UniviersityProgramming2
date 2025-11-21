package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий книгу
 */
public class Book implements Printable {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title + " by " + author + " (" + year + ")");
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    /**
     * Статический метод для печати только книг из массива Printable
     */
    public static void printBooks(Printable[] printables) {
        System.out.println("\n=== Печать только книг ===");
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                printable.print();
            }
        }
    }
}
