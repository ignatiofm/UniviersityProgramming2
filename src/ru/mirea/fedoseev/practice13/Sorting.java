package ru.mirea.fedoseev.practice13;

import java.util.Comparator;

public class Sorting {

    public static <T extends Comparable<T>> void insertionSort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            T key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void selectionSort(Comparable[] list) {
        int min;
        Comparable temp;
        for (int index = 0; index < list.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < list.length; scan++) {
                if (list[scan].compareTo(list[min]) < 0) {
                    min = scan;
                    temp = list[min];
                    list[min] = list[index];
                    list[index] = temp;
                }
            }
        }
    }

    public static <T> void quickSort(T[] list, Comparator<T> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <T> void quickSort(T[] list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] list, int low, int high, Comparator<T> comparator) {
        T pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list[j], pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] list) {
        if (list.length > 1) {
            int mid = list.length / 2;

                        T[] left = (T[]) new Comparable[mid];
                        T[] right = (T[]) new Comparable[list.length - mid];

            System.arraycopy(list, 0, left, 0, mid);
            System.arraycopy(list, mid, right, 0, list.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(list, left, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] list, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }
        while (i < left.length) {
            list[k++] = left[i++];
        }
        while (j < right.length) {
            list[k++] = right[j++];
        }
    }

    public static <T extends Comparable<T>> void mergeTwoSortedArrays(T[] array1, T[] array2, T[] result) {
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) <= 0) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        while (j < array2.length) {
            result[k++] = array2[j++];
        }
    }

    private static <T> void swap(T[] list, int i, int j) {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
