package ru.mirea.fedoseev.practice5.computerShop;

import java.util.Scanner;

/**
 * Реализация ввода данных о компьютере с консоли
 */
public class ConsoleComputerInput implements ComputerInput {

    @Override
    public Computer inputComputer(Scanner scanner) {
        System.out.println("\n=== Ввод данных о компьютере ===");

        // Выбор бренда
        System.out.println("Выберите бренд:");
        ComputerBrand[] brands = ComputerBrand.values();
        for (int i = 0; i < brands.length; i++) {
            System.out.println((i + 1) + ". " + brands[i].getDisplayName());
        }
        System.out.print("Ваш выбор (1-" + brands.length + "): ");
        int brandChoice = scanner.nextInt();
        scanner.nextLine();
        ComputerBrand brand = brands[brandChoice - 1];

        // Ввод модели
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();

        // Ввод данных о процессоре
        System.out.println("\n--- Процессор ---");
        System.out.print("Модель процессора: ");
        String cpuModel = scanner.nextLine();
        System.out.print("Частота (GHz): ");
        double frequency = scanner.nextDouble();
        System.out.print("Количество ядер: ");
        int cores = scanner.nextInt();
        scanner.nextLine();
        Processor processor = new Processor(cpuModel, frequency, cores);

        // Ввод данных о памяти
        System.out.println("\n--- Память ---");
        System.out.print("Тип памяти (DDR4/DDR5): ");
        String memType = scanner.nextLine();
        System.out.print("Объем (GB): ");
        int memSize = scanner.nextInt();
        scanner.nextLine();
        Memory memory = new Memory(memType, memSize);

        // Ввод данных о мониторе
        System.out.println("\n--- Монитор ---");
        System.out.print("Диагональ (дюймы): ");
        double monitorSize = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Разрешение (1920x1080/2560x1440 и т.д.): ");
        String resolution = scanner.nextLine();
        System.out.print("Тип (IPS/VA/TN): ");
        String monitorType = scanner.nextLine();
        Monitor monitor = new Monitor(monitorSize, resolution, monitorType);

        // Ввод цены
        System.out.print("\nЦена (руб.): ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        return new Computer(brand, model, processor, memory, monitor, price);
    }
}
