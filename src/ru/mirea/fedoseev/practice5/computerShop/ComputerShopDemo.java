package ru.mirea.fedoseev.practice5.computerShop;

import java.util.List;
import java.util.Scanner;

/**
 * Демонстрация работы интернет-магазина компьютеров
 */
public class ComputerShopDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerShop shop = new ComputerShop("TechnoWorld");
        ComputerInput inputHandler = new ConsoleComputerInput();

        // Добавим несколько компьютеров для демонстрации
        addSampleComputers(shop);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Меню интернет-магазина компьютеров ===");
            System.out.println("1. Показать все компьютеры");
            System.out.println("2. Добавить компьютер");
            System.out.println("3. Удалить компьютер");
            System.out.println("4. Найти компьютеры по бренду");
            System.out.println("5. Найти компьютеры по цене");
            System.out.println("6. Найти компьютеры по объему памяти");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shop.showAllComputers();
                    break;

                case 2:
                    Computer newComputer = inputHandler.inputComputer(scanner);
                    shop.addComputer(newComputer);
                    break;

                case 3:
                    shop.showAllComputers();
                    System.out.print("Введите индекс компьютера для удаления: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    shop.removeComputer(index);
                    break;

                case 4:
                    System.out.println("Выберите бренд:");
                    ComputerBrand[] brands = ComputerBrand.values();
                    for (int i = 0; i < brands.length; i++) {
                        System.out.println((i + 1) + ". " + brands[i].getDisplayName());
                    }
                    System.out.print("Ваш выбор: ");
                    int brandChoice = scanner.nextInt();
                    scanner.nextLine();
                    ComputerBrand selectedBrand = brands[brandChoice - 1];
                    List<Computer> byBrand = shop.findByBrand(selectedBrand);
                    System.out.println("\nНайдено компьютеров: " + byBrand.size());
                    for (Computer c : byBrand) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.print("Минимальная цена: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Максимальная цена: ");
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine();
                    List<Computer> byPrice = shop.findByPriceRange(minPrice, maxPrice);
                    System.out.println("\nНайдено компьютеров: " + byPrice.size());
                    for (Computer c : byPrice) {
                        System.out.println(c);
                    }
                    break;

                case 6:
                    System.out.print("Минимальный объем памяти (GB): ");
                    int minMemory = scanner.nextInt();
                    scanner.nextLine();
                    List<Computer> byMemory = shop.findByMinMemory(minMemory);
                    System.out.println("\nНайдено компьютеров: " + byMemory.size());
                    for (Computer c : byMemory) {
                        System.out.println(c);
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("До свидания!");
                    break;

                default:
                    System.out.println("Неверный выбор");
            }
        }

        scanner.close();
    }

    /**
     * Добавить примеры компьютеров для демонстрации
     */
    private static void addSampleComputers(ComputerShop shop) {
        shop.addComputer(new Computer(
            ComputerBrand.HP,
            "Pavilion Gaming",
            new Processor("Intel Core i5-12400F", 4.4, 6),
            new Memory("DDR4", 16),
            new Monitor(24, "1920x1080", "IPS"),
            65000
        ));

        shop.addComputer(new Computer(
            ComputerBrand.LENOVO,
            "IdeaCentre 5",
            new Processor("AMD Ryzen 5 5600G", 4.4, 6),
            new Memory("DDR4", 8),
            new Monitor(21.5, "1920x1080", "VA"),
            55000
        ));

        shop.addComputer(new Computer(
            ComputerBrand.ACER,
            "Aspire TC",
            new Processor("Intel Core i7-12700", 4.9, 12),
            new Memory("DDR5", 32),
            new Monitor(27, "2560x1440", "IPS"),
            95000
        ));

        shop.addComputer(new Computer(
            ComputerBrand.DELL,
            "XPS Desktop",
            new Processor("Intel Core i9-13900K", 5.8, 24),
            new Memory("DDR5", 64),
            new Monitor(32, "3840x2160", "IPS"),
            180000
        ));

        shop.addComputer(new Computer(
            ComputerBrand.ASUS,
            "ROG Strix G10",
            new Processor("AMD Ryzen 7 5800X", 4.7, 8),
            new Memory("DDR4", 16),
            new Monitor(27, "2560x1440", "IPS"),
            85000
        ));

        System.out.println("Добавлено " + shop.getComputers().size() + " примеров компьютеров");
    }
}
