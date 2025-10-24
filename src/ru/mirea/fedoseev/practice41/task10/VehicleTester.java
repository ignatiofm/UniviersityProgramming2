package ru.mirea.fedoseev.practice41.task10;

public class VehicleTester {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Автомобиль Toyota", 100, 8, 4),
            new Plane("Самолет Boeing 737", 800, 50, 180),
            new Train("Поезд Сапсан", 200, 5, 10),
            new Ship("Грузовой корабль", 40, 2, 50000)
        };

        double distance = 1000; // км
        int passengers = 50;
        double cargoWeight = 5000; // кг

        System.out.println("=== Сравнение транспортных средств ===");
        System.out.println("Расстояние: " + distance + " км");
        System.out.println("Пассажиров: " + passengers + " чел.");
        System.out.println("Груз: " + cargoWeight + " кг");
        System.out.println();

        for (Vehicle vehicle : vehicles) {
            System.out.println("--- " + vehicle.getName() + " ---");
            System.out.println(vehicle);

            double time = vehicle.calculateTime(distance);
            System.out.printf("Время в пути: %.2f часов\n", time);

            try {
                double passengerCost = vehicle.calculatePassengerCost(distance, passengers);
                System.out.printf("Стоимость перевозки %d пассажиров: %.2f руб.\n",
                                passengers, passengerCost);
            } catch (IllegalArgumentException e) {
                System.out.println("Перевозка пассажиров: " + e.getMessage());
            }

            try {
                double cargoCost = vehicle.calculateCargoCost(distance, cargoWeight);
                System.out.printf("Стоимость перевозки %.0f кг груза: %.2f руб.\n",
                                cargoWeight, cargoCost);
            } catch (IllegalArgumentException e) {
                System.out.println("Перевозка груза: " + e.getMessage());
            }

            System.out.println();
        }

        System.out.println("=== Сравнительная таблица ===");
        System.out.printf("%-25s %-15s %-20s %-20s\n",
                         "Транспорт", "Время (ч)", "Пассажиры (руб)", "Груз (руб)");
        for (int i = 0; i < 85; i++) System.out.print("=");
        System.out.println();

        for (Vehicle vehicle : vehicles) {
            double time = vehicle.calculateTime(distance);
            String passengerCost = "N/A";
            String cargoCost = "N/A";

            try {
                passengerCost = String.format("%.2f", vehicle.calculatePassengerCost(distance, passengers));
            } catch (Exception e) {
                passengerCost = "Невозможно";
            }

            try {
                cargoCost = String.format("%.2f", vehicle.calculateCargoCost(distance, cargoWeight));
            } catch (Exception e) {
                cargoCost = "Невозможно";
            }

            System.out.printf("%-25s %-15.2f %-20s %-20s\n",
                             vehicle.getName(), time, passengerCost, cargoCost);
        }
    }
}
