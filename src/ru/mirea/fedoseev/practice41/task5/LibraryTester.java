package ru.mirea.fedoseev.practice41.task5;

public class LibraryTester {
    public static void main(String[] args) {
        Reader[] readers = {
            new Reader("Петров В. В.", "12345", "Информатика",
                      "15.03.2001", "+7-900-111-11-11"),
            new Reader("Иванов И. И.", "23456", "Математика",
                      "20.05.2000", "+7-911-222-22-22"),
            new Reader("Сидорова А. А.", "34567", "Физика",
                      "10.07.2002", "+7-922-333-33-33")
        };

        Book book1 = new Book("Приключения", "А. Дюма");
        Book book2 = new Book("Словарь", "С. Ожегов");
        Book book3 = new Book("Энциклопедия", "Коллектив авторов");

        System.out.println("=== Информация о читателях ===");
        for (Reader reader : readers) {
            System.out.println(reader);
        }
        System.out.println();

        System.out.println("=== Взятие книг (количество) ===");
        readers[0].takeBook(3);
        readers[1].takeBook(2);
        readers[2].takeBook(5);
        System.out.println();

        System.out.println("=== Взятие книг (названия) ===");
        readers[0].takeBook("Приключения", "Словарь", "Энциклопедия");
        readers[1].takeBook("Война и мир", "Преступление и наказание");
        System.out.println();

        System.out.println("=== Взятие книг (объекты Book) ===");
        readers[0].takeBook(book1, book2, book3);
        readers[2].takeBook(book1, book2);
        System.out.println();

        System.out.println("=== Возврат книг (количество) ===");
        readers[0].returnBook(3);
        readers[1].returnBook(2);
        System.out.println();

        System.out.println("=== Возврат книг (названия) ===");
        readers[0].returnBook("Приключения", "Словарь", "Энциклопедия");
        System.out.println();

        System.out.println("=== Возврат книг (объекты Book) ===");
        readers[2].returnBook(book1, book2);
    }
}
