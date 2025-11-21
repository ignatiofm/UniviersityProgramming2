package ru.mirea.fedoseev.practice5.computerShop;

/**
 * Класс, представляющий компьютер
 */
public class Computer {
    private ComputerBrand brand;
    private String model;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    private double price;

    public Computer(ComputerBrand brand, String model, Processor processor,
                    Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }

    public ComputerBrand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return brand.getDisplayName() + " " + model +
               " [CPU: " + processor +
               ", RAM: " + memory +
               ", Monitor: " + monitor +
               ", Price: " + price + " руб.]";
    }

    public void displayFullInfo() {
        System.out.println("\n=== Информация о компьютере ===");
        System.out.println("Бренд: " + brand.getDisplayName());
        System.out.println("Модель: " + model);
        System.out.println("Процессор: " + processor);
        System.out.println("Память: " + memory);
        System.out.println("Монитор: " + monitor);
        System.out.println("Цена: " + price + " руб.");
    }
}
