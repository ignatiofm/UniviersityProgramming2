package ru.mirea.fedoseev.practice11;

import java.util.Scanner;

public class Task8 {
    public static boolean isPalindrome(String word, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }

        return isPalindrome(word, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        System.out.println(isPalindrome(word, 0, word.length() - 1) ? "YES" : "NO");

        scanner.close();
    }
}
