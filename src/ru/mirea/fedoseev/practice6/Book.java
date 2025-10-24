package ru.mirea.fedoseev.practice6;

public class Book implements Printable {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Book: " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    public static void printBooks(Printable[] printables) {
        System.out.println("\n=== Книги ===");
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                System.out.println(printable.getName());
            }
        }
    }
}
