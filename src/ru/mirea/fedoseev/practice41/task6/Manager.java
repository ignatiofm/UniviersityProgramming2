package ru.mirea.fedoseev.practice41.task6;

public class Manager extends Employer {
    private double averageSum;

    public Manager(String firstName, String lastName, double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    public double getAverageSum() {
        return averageSum;
    }

    @Override
    public double getIncome() {
        return super.getIncome() + averageSum * 12;
    }

    @Override
    public String toString() {
        return "Manager{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", monthlyIncome=" + income +
               ", averageSalesBonus=" + averageSum +
               '}';
    }
}
