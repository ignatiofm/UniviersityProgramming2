package ru.mirea.fedoseev.practice5.computerShop;

import java.util.Scanner;

/**
 * Интерфейс для ввода данных о компьютере
 */
public interface ComputerInput {
    Computer inputComputer(Scanner scanner);
}
