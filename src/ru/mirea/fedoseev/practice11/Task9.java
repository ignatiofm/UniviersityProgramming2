package ru.mirea.fedoseev.practice11;

import java.util.Scanner;

public class Task9 {
    public static int countSequences(int a, int b) {
        if (a == 0) {
            return 1;
        }
        if (b == 0) {
            return (a == 1) ? 1 : 0;
        }
        if (a < 0 || b < 0) {
            return 0;
        }

        return countSequences(a, b - 1) + countSequences(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(countSequences(a, b));

        scanner.close();
    }
}
