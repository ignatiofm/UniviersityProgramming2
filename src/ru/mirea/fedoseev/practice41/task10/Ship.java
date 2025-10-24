package ru.mirea.fedoseev.practice41.task10;

public class Ship extends Vehicle {
    private double cargoCapacity;

    public Ship(String name, double speed, double costPerKm, double cargoCapacity) {
        super(name, speed, costPerKm);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        return distance * costPerKm * passengers * 0.6;
    }

    @Override
    public double calculateCargoCost(double distance, double cargoWeight) {
        if (cargoWeight > cargoCapacity) {
            throw new IllegalArgumentException("Груз превышает грузоподъемность корабля");
        }
        return distance * costPerKm * (cargoWeight / 1000.0);
    }
}
