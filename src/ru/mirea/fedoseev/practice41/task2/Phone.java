package ru.mirea.fedoseev.practice41.task2;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {
        this.number = "Unknown";
        this.model = "Unknown";
        this.weight = 0.0;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " с номера " + callerNumber);
    }

    public String getNumber() {
        return number;
    }

    public void sendMessage(String... numbers) {
        System.out.println("Отправка сообщения на номера:");
        for (String phoneNumber : numbers) {
            System.out.println(phoneNumber);
        }
    }

    @Override
    public String toString() {
        return "Phone{number='" + number + "', model='" + model + "', weight=" + weight + "}";
    }
}
