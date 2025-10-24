package ru.mirea.fedoseev.practice41.task10;

public class Train extends Vehicle {
    private int carriages;

    public Train(String name, double speed, double costPerKm, int carriages) {
        super(name, speed, costPerKm);
        this.carriages = carriages;
    }

    @Override
    public double calculateTime(double distance) {
        return (distance / speed) + 1;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        return distance * costPerKm * passengers * 0.8;
    }

    @Override
    public double calculateCargoCost(double distance, double cargoWeight) {
        return distance * costPerKm * (cargoWeight / 100.0) * carriages;
    }
}
