package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий подписку
 */
public class Subscription implements Priceable {
    private String name;
    private double monthlyPrice;
    private int months;

    public Subscription(String name, double monthlyPrice, int months) {
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.months = months;
    }

    @Override
    public double getPrice() {
        return monthlyPrice * months;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getMonths() {
        return months;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "name='" + name + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", months=" + months +
                ", totalPrice=" + getPrice() +
                '}';
    }
}
