package ru.mirea.fedoseev.practice41.task10;

public class Car extends Vehicle {
    private int maxPassengers;

    public Car(String name, double speed, double costPerKm, int maxPassengers) {
        super(name, speed, costPerKm);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (passengers > maxPassengers) {
            throw new IllegalArgumentException("Слишком много пассажиров для автомобиля");
        }
        return distance * costPerKm;
    }

    @Override
    public double calculateCargoCost(double distance, double cargoWeight) {
        double weightCoefficient = 1.0 + (cargoWeight / 100.0);
        return distance * costPerKm * weightCoefficient;
    }
}
