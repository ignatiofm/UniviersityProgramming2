package ru.mirea.fedoseev.practice41.task6;

public class EmployerTester {
    public static void main(String[] args) {
        Employer emp = new Manager("Иван", "Петров", 50000, 10000);

        System.out.println("=== Демонстрация полиморфизма ===");
        System.out.println(emp);
        System.out.println("Годовой доход: " + emp.getIncome());
        System.out.println();

        Employer[] employees = {
            new Employer("Алексей", "Иванов", 40000),
            new Employer("Мария", "Сидорова", 45000),
            new Manager("Петр", "Смирнов", 50000, 8000),
            new Manager("Анна", "Кузнецова", 55000, 12000),
            new Employer("Дмитрий", "Попов", 42000)
        };

        System.out.println("=== Информация о сотрудниках ===");
        double totalIncome = 0;
        for (int i = 0; i < employees.length; i++) {
            System.out.println((i + 1) + ". " + employees[i]);
            double income = employees[i].getIncome();
            System.out.println("   Годовой доход: " + income + " руб.");
            totalIncome += income;
            System.out.println();
        }

        System.out.println("Общая сумма годовых выплат: " + totalIncome + " руб.");
    }
}
