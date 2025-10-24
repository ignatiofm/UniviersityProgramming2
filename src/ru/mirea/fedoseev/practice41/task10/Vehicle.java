package ru.mirea.fedoseev.practice41.task10;

public abstract class Vehicle {
    protected String name;
    protected double speed;
    protected double costPerKm;

    public Vehicle(String name, double speed, double costPerKm) {
        this.name = name;
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    public abstract double calculateTime(double distance);
    public abstract double calculatePassengerCost(double distance, int passengers);
    public abstract double calculateCargoCost(double distance, double cargoWeight);

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    @Override
    public String toString() {
        return name + " (скорость: " + speed + " км/ч, стоимость: " + costPerKm + " руб/км)";
    }
}
