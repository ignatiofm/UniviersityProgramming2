package ru.mirea.fedoseev.practice4;

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

    public void setBrand(ComputerBrand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayFullInfo() {
        System.out.println("\n=== Информация о компьютере ===");
        System.out.println("Бренд: " + brand.getDisplayName());
        System.out.println("Модель: " + model);
        System.out.println("\nКомпоненты:");
        processor.displayInfo();
        memory.displayInfo();
        monitor.displayInfo();
        System.out.println("\nЦена: " + price + " руб.");
    }

    public void powerOn() {
        System.out.println("Компьютер " + brand.getDisplayName() + " " + model + " включается...");
    }

    public void powerOff() {
        System.out.println("Компьютер " + brand.getDisplayName() + " " + model + " выключается...");
    }

    @Override
    public String toString() {
        return "Computer{" +
               "brand=" + brand.getDisplayName() +
               ", model='" + model + "'" +
               ", processor=" + processor +
               ", memory=" + memory +
               ", monitor=" + monitor +
               ", price=" + price + " руб.}";
    }
}
