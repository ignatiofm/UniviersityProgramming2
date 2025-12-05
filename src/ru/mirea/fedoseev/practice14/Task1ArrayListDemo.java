package ru.mirea.fedoseev.practice14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task1ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("=== Тестирование ArrayList ===\n");

        ArrayList<String> cities = new ArrayList<>();

        System.out.println("1. Добавление элементов:");
        cities.add("Москва");
        cities.add("Санкт-Петербург");
        cities.add("Новосибирск");
        cities.add("Екатеринбург");
        cities.add(1, "Казань");
        System.out.println("Список городов: " + cities);
        System.out.println("Размер списка: " + cities.size());

        System.out.println("\n2. Получение элементов:");
        System.out.println("Первый элемент: " + cities.get(0));
        System.out.println("Третий элемент: " + cities.get(2));

        System.out.println("\n3. Изменение элементов:");
        cities.set(2, "Нижний Новгород");
        System.out.println("После замены элемента с индексом 2: " + cities);

        System.out.println("\n4. Поиск элементов:");
        System.out.println("Индекс 'Москва': " + cities.indexOf("Москва"));
        System.out.println("Содержит 'Казань': " + cities.contains("Казань"));
        System.out.println("Содержит 'Владивосток': " + cities.contains("Владивосток"));

        System.out.println("\n5. Удаление элементов:");
        cities.remove("Казань");
        System.out.println("После удаления 'Казань': " + cities);
        cities.remove(0);
        System.out.println("После удаления первого элемента: " + cities);

        System.out.println("\n6. Сортировка:");
        cities.add("Астрахань");
        cities.add("Владимир");
        System.out.println("До сортировки: " + cities);
        Collections.sort(cities);
        System.out.println("После сортировки: " + cities);
        Collections.sort(cities, Comparator.reverseOrder());
        System.out.println("Обратная сортировка: " + cities);

        System.out.println("\n7. ArrayList с числами:");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Числа: " + numbers);

        System.out.println("\n8. Подсписок:");
        System.out.println("Подсписок (2-5): " + numbers.subList(2, 5));

        System.out.println("\n9. Преобразование в массив:");
        Object[] array = numbers.toArray();
        System.out.print("Массив: ");
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("\n10. Очистка списка:");
        System.out.println("Список пуст? " + numbers.isEmpty());
        numbers.clear();
        System.out.println("После очистки, список пуст? " + numbers.isEmpty());

        System.out.println("\n11. ArrayList с пользовательскими объектами:");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 4.5));
        students.add(new Student("Петров", 3.8));
        students.add(new Student("Сидоров", 4.9));

        System.out.println("Список студентов:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("\nОтсортированы по среднему баллу (убывание):");
        for (Student s : students) {
            System.out.println("  " + s);
        }
    }
}

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " (средний балл: " + gpa + ")";
    }
}
