package ru.mirea.fedoseev.practice11;

import java.util.Scanner;

public class Task6 {
    public static boolean isPrime(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("NO");
        } else if (n == 2) {
            System.out.println("YES");
        } else {
            System.out.println(isPrime(n, 2) ? "YES" : "NO");
        }

        scanner.close();
    }
}
