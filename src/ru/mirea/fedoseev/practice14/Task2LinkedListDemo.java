package ru.mirea.fedoseev.practice14;

import java.util.Iterator;
import java.util.LinkedList;

public class Task2LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("=== Тестирование LinkedList ===\n");

        LinkedList<String> countries = new LinkedList<>();

        System.out.println("1. Добавление элементов:");
        countries.add("Россия");
        countries.add("Германия");
        countries.add("Франция");
        countries.addFirst("США");
        countries.addLast("Китай");
        countries.add(2, "Италия");
        System.out.println("Список стран: " + countries);

        System.out.println("\n2. Методы offer:");
        countries.offerFirst("Канада");
        countries.offerLast("Япония");
        System.out.println("После offerFirst и offerLast: " + countries);

        System.out.println("\n3. Получение элементов:");
        System.out.println("Первый элемент (getFirst): " + countries.getFirst());
        System.out.println("Последний элемент (getLast): " + countries.getLast());
        System.out.println("Элемент по индексу 3: " + countries.get(3));

        System.out.println("\n4. Методы peek (не удаляют элементы):");
        System.out.println("peekFirst: " + countries.peekFirst());
        System.out.println("peekLast: " + countries.peekLast());
        System.out.println("Размер после peek: " + countries.size());

        System.out.println("\n5. Удаление элементов:");
        System.out.println("Удален первый (removeFirst): " + countries.removeFirst());
        System.out.println("Удален последний (removeLast): " + countries.removeLast());
        System.out.println("После удаления: " + countries);

        System.out.println("\n6. Методы poll (удаляют и возвращают):");
        System.out.println("pollFirst: " + countries.pollFirst());
        System.out.println("pollLast: " + countries.pollLast());
        System.out.println("После poll: " + countries);

        System.out.println("\n7. Использование как очереди (FIFO):");
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("Первый в очереди");
        queue.offer("Второй в очереди");
        queue.offer("Третий в очереди");
        System.out.println("Очередь: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("poll: " + queue.poll());
        System.out.println("Осталось: " + queue);

        System.out.println("\n8. Использование как стека (LIFO):");
        LinkedList<String> stack = new LinkedList<>();
        stack.push("Первый");
        stack.push("Второй");
        stack.push("Третий");
        System.out.println("Стек: " + stack);
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("Осталось в стеке: " + stack);

        System.out.println("\n9. Итерация в обратном порядке:");
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        System.out.print("Прямой порядок: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.print("\nОбратный порядок: ");
        Iterator<Integer> descendingIterator = numbers.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();

        System.out.println("\n10. LinkedList с пользовательскими объектами:");
        LinkedList<Book> books = new LinkedList<>();
        books.add(new Book("Война и мир", "Толстой"));
        books.addFirst(new Book("Преступление и наказание", "Достоевский"));
        books.addLast(new Book("Мастер и Маргарита", "Булгаков"));

        System.out.println("Список книг:");
        for (Book book : books) {
            System.out.println("  " + book);
        }

        System.out.println("\nПервая книга: " + books.getFirst());
        System.out.println("Последняя книга: " + books.getLast());

        System.out.println("\n11. Демонстрация вставки в начало:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.addFirst(i);
        }
        long linkedTime = System.nanoTime() - start;

        java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long arrayTime = System.nanoTime() - start;

        System.out.println("LinkedList addFirst (10000 элементов): " + linkedTime / 1_000_000.0 + " мс");
        System.out.println("ArrayList add(0, x) (10000 элементов): " + arrayTime / 1_000_000.0 + " мс");
        System.out.println("LinkedList быстрее в " + String.format("%.1f", (double) arrayTime / linkedTime) + " раз");
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" - " + author;
    }
}
