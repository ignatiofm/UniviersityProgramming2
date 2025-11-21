package ru.mirea.fedoseev.task9;

/**
 * Задание 5: Создать массив объектов Circle и найти круг с самой большой площадью
 */
public class Task5 {
    public static void main(String[] args) {
        // Создаем массив из 10 кругов с разными радиусами
        Circle[] circles = new Circle[10];

        // Инициализируем массив кругов
        circles[0] = new Circle(5.5);
        circles[1] = new Circle(3.2);
        circles[2] = new Circle(7.8);
        circles[3] = new Circle(2.1);
        circles[4] = new Circle(9.3);
        circles[5] = new Circle(4.6);
        circles[6] = new Circle(6.7);
        circles[7] = new Circle(1.5);
        circles[8] = new Circle(8.4);
        circles[9] = new Circle(3.9);

        // Выводим все круги
        System.out.println("=== ВСЕ КРУГИ ===");
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Circle[" + i + "]: " + circles[i]);
        }

        // Находим круг с самой большой площадью
        Circle maxCircle = findCircleWithMaxArea(circles);

        // Выводим результат
        System.out.println("\n=== КРУГ С МАКСИМАЛЬНОЙ ПЛОЩАДЬЮ ===");
        System.out.println(maxCircle);
        System.out.println("Площадь: " + String.format("%.2f", maxCircle.getArea()));
    }

    /**
     * Метод для поиска круга с максимальной площадью
     * @param circles массив кругов
     * @return круг с максимальной площадью
     */
    public static Circle findCircleWithMaxArea(Circle[] circles) {
        if (circles == null || circles.length == 0) {
            return null;
        }

        Circle maxCircle = circles[0];
        double maxArea = circles[0].getArea();

        for (int i = 1; i < circles.length; i++) {
            double currentArea = circles[i].getArea();
            if (currentArea > maxArea) {
                maxArea = currentArea;
                maxCircle = circles[i];
            }
        }

        return maxCircle;
    }
}
