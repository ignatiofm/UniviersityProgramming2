package ru.mirea.fedoseev.practice14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task3CustomArrayList {
    public static void main(String[] args) {
        System.out.println("=== Тестирование MyArrayList ===\n");

        MyArrayList<String> list = new MyArrayList<>();

        System.out.println("1. Добавление элементов:");
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        list.add("Пять");
        System.out.println("Список: " + list);
        System.out.println("Размер: " + list.size());

        System.out.println("\n2. Добавление по индексу:");
        list.add(2, "Два с половиной");
        System.out.println("После добавления по индексу 2: " + list);

        System.out.println("\n3. Получение элементов:");
        System.out.println("Элемент [0]: " + list.get(0));
        System.out.println("Элемент [3]: " + list.get(3));

        System.out.println("\n4. Изменение элементов:");
        list.set(1, "ДВА (изменено)");
        System.out.println("После set(1, ...): " + list);

        System.out.println("\n5. Поиск элементов:");
        System.out.println("indexOf('Три'): " + list.indexOf("Три"));
        System.out.println("indexOf('Десять'): " + list.indexOf("Десять"));
        System.out.println("contains('Пять'): " + list.contains("Пять"));
        System.out.println("contains('Сто'): " + list.contains("Сто"));

        System.out.println("\n6. Удаление элементов:");
        list.remove(2);
        System.out.println("После remove(2): " + list);
        list.remove("Четыре");
        System.out.println("После remove('Четыре'): " + list);

        System.out.println("\n7. Итерация:");
        System.out.print("for-each: ");
        for (String s : list) {
            System.out.print(s + " | ");
        }
        System.out.println();

        System.out.println("\n8. Тест с числами:");
        MyArrayList<Integer> numbers = new MyArrayList<>(5);
        for (int i = 1; i <= 20; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Числа: " + numbers);
        System.out.println("Размер: " + numbers.size());

        System.out.println("\n9. Преобразование в массив:");
        Object[] array = numbers.toArray();
        System.out.println("Массив: " + Arrays.toString(array));

        System.out.println("\n10. Очистка списка:");
        System.out.println("isEmpty до очистки: " + numbers.isEmpty());
        numbers.clear();
        System.out.println("isEmpty после очистки: " + numbers.isEmpty());
        System.out.println("Размер после очистки: " + numbers.size());

        System.out.println("\n11. Тест автоматического расширения емкости (x2):");
        MyArrayList<Integer> expandTest = new MyArrayList<>(2);
        System.out.println("Начальная емкость: 2");
        for (int i = 1; i <= 10; i++) {
            expandTest.add(i);
            System.out.println("Добавлен: " + i + ", размер: " + expandTest.size() + ", емкость: " + expandTest.capacity());
        }
        System.out.println("Итоговый список: " + expandTest);
    }
}

class MyArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) {
            if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length == 0 ? DEFAULT_CAPACITY : elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
                        public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[cursor++];
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        return sb.append("]").toString();
    }
}
