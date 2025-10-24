package ru.mirea.fedoseev.practice4;

public class Processor {
    private String model;
    private int cores;
    private double frequency;

    public Processor(String model, int cores, double frequency) {
        this.model = model;
        this.cores = cores;
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void displayInfo() {
        System.out.println("  Процессор: " + model);
        System.out.println("  Ядер: " + cores);
        System.out.println("  Частота: " + frequency + " GHz");
    }

    @Override
    public String toString() {
        return "Processor{model='" + model + "', cores=" + cores + ", frequency=" + frequency + " GHz}";
    }
}
