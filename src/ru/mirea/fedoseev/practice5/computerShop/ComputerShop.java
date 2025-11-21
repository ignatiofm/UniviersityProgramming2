package ru.mirea.fedoseev.practice5.computerShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий интернет-магазин компьютеров
 */
public class ComputerShop {
    private String name;
    private List<Computer> computers;

    public ComputerShop(String name) {
        this.name = name;
        this.computers = new ArrayList<>();
    }

    /**
     * Добавить компьютер в магазин
     */
    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер добавлен в магазин: " + computer.getBrand().getDisplayName() + " " + computer.getModel());
    }

    /**
     * Удалить компьютер по индексу
     */
    public boolean removeComputer(int index) {
        if (index >= 0 && index < computers.size()) {
            Computer removed = computers.remove(index);
            System.out.println("Компьютер удален: " + removed.getBrand().getDisplayName() + " " + removed.getModel());
            return true;
        }
        System.out.println("Компьютер с индексом " + index + " не найден");
        return false;
    }

    /**
     * Найти компьютеры по бренду
     */
    public List<Computer> findByBrand(ComputerBrand brand) {
        List<Computer> result = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.getBrand() == brand) {
                result.add(computer);
            }
        }
        return result;
    }

    /**
     * Найти компьютеры по диапазону цен
     */
    public List<Computer> findByPriceRange(double minPrice, double maxPrice) {
        List<Computer> result = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.getPrice() >= minPrice && computer.getPrice() <= maxPrice) {
                result.add(computer);
            }
        }
        return result;
    }

    /**
     * Найти компьютеры по минимальному объему памяти
     */
    public List<Computer> findByMinMemory(int minMemory) {
        List<Computer> result = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.getMemory().getSize() >= minMemory) {
                result.add(computer);
            }
        }
        return result;
    }

    /**
     * Показать все компьютеры в магазине
     */
    public void showAllComputers() {
        System.out.println("\n=== Магазин: " + name + " ===");
        System.out.println("Всего компьютеров: " + computers.size());
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст");
        } else {
            for (int i = 0; i < computers.size(); i++) {
                System.out.println("[" + i + "] " + computers.get(i));
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Computer> getComputers() {
        return computers;
    }
}
