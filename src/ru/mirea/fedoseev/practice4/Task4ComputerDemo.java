package ru.mirea.fedoseev.practice4;

public class Task4ComputerDemo {
    public static void main(String[] args) {
        Processor processor1 = new Processor("Intel Core i7-12700K", 12, 3.6);
        Memory memory1 = new Memory("DDR4", 16);
        Monitor monitor1 = new Monitor(27, "2560x1440", "IPS");

        Computer computer1 = new Computer(
            ComputerBrand.DELL,
            "XPS 8950",
            processor1,
            memory1,
            monitor1,
            95000
        );

        Processor processor2 = new Processor("AMD Ryzen 9 5900X", 12, 3.7);
        Memory memory2 = new Memory("DDR4", 32);
        Monitor monitor2 = new Monitor(32, "3840x2160", "OLED");

        Computer computer2 = new Computer(
            ComputerBrand.ASUS,
            "ROG Strix G15",
            processor2,
            memory2,
            monitor2,
            125000
        );

        Processor processor3 = new Processor("Apple M2", 8, 3.5);
        Memory memory3 = new Memory("Unified Memory", 16);
        Monitor monitor3 = new Monitor(24, "4096x2304", "Retina");

        Computer computer3 = new Computer(
            ComputerBrand.APPLE,
            "iMac 24\"",
            processor3,
            memory3,
            monitor3,
            150000
        );

        computer1.displayFullInfo();
        computer1.powerOn();
        computer1.powerOff();

        System.out.println("\n==================================================");

        computer2.displayFullInfo();
        computer2.powerOn();
        computer2.powerOff();

        System.out.println("\n==================================================");

        computer3.displayFullInfo();
        computer3.powerOn();
        computer3.powerOff();

        System.out.println("\n=== Доступные бренды компьютеров ===");
        for (ComputerBrand brand : ComputerBrand.values()) {
            System.out.println("- " + brand.getDisplayName());
        }
    }
}
