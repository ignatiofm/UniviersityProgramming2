package ru.mirea.fedoseev.practice5.computerShop;

/**
 * Класс, представляющий процессор
 */
public class Processor {
    private String model;
    private double frequency;
    private int cores;

    public Processor(String model, double frequency, int cores) {
        this.model = model;
        this.frequency = frequency;
        this.cores = cores;
    }

    public String getModel() {
        return model;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return cores;
    }

    @Override
    public String toString() {
        return model + " (" + frequency + " GHz, " + cores + " cores)";
    }
}
