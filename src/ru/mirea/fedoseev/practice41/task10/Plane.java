package ru.mirea.fedoseev.practice41.task10;

public class Plane extends Vehicle {
    private int maxPassengers;

    public Plane(String name, double speed, double costPerKm, int maxPassengers) {
        super(name, speed, costPerKm);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public double calculateTime(double distance) {
        return (distance / speed) + 2;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (passengers > maxPassengers) {
            throw new IllegalArgumentException("Слишком много пассажиров для самолета");
        }
        return distance * costPerKm * passengers;
    }

    @Override
    public double calculateCargoCost(double distance, double cargoWeight) {
        return distance * costPerKm * (cargoWeight / 10.0);
    }
}
