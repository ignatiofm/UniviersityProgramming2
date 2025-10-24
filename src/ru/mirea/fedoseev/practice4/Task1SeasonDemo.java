package ru.mirea.fedoseev.practice4;

public class Task1SeasonDemo {

    public static void printSeasonInfo(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        Season favoriteSeason = Season.SUMMER;
        System.out.println("Мое любимое время года: " + favoriteSeason);
        System.out.println("Средняя температура: " + favoriteSeason.getAverageTemperature() + "°C");
        System.out.println("Описание: " + favoriteSeason.getDescription());

        System.out.println("\n--- Метод с switch ---");
        printSeasonInfo(favoriteSeason);

        System.out.println("\n--- Все времена года ---");
        for (Season season : Season.values()) {
            System.out.println("Время года: " + season);
            System.out.println("Средняя температура: " + season.getAverageTemperature() + "°C");
            System.out.println("Описание: " + season.getDescription());
            System.out.println();
        }
    }
}
