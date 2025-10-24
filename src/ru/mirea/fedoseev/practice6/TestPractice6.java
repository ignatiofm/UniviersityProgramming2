package ru.mirea.fedoseev.practice6;

public class TestPractice6 {
    public static void main(String[] args) {
        System.out.println("=== Практическая работа № 6 ===\n");

        System.out.println("--- Задание 1-3: Movable, MovablePoint, MovableRectangle ---");

        MovablePoint point = new MovablePoint(0, 0, 5, 5);
        System.out.println("Создана точка: " + point);
        point.moveRight();
        point.moveUp();
        System.out.println("После движения вправо и вверх: " + point);

        MovableRectangle rectangle = new MovableRectangle(0, 10, 10, 0, 3, 3);
        System.out.println("\nСоздан прямоугольник: " + rectangle);
        System.out.println("Тест скорости (speedTest): " + rectangle.speedTest());

        rectangle.moveRight();
        rectangle.moveDown();
        System.out.println("После движения вправо и вниз: " + rectangle);

        System.out.println("\n--- Задание 4: MathCalculable, MathFunc ---");

        // Правильный способ создания экземпляра
        MathCalculable mc1 = new MathFunc();
        System.out.println("Использование PI из интерфейса: " + MathCalculable.PI);

        double power = mc1.power(2, 3);
        System.out.println("2^3 = " + power);

        double module = mc1.complexModule(3, 4);
        System.out.println("Модуль комплексного числа (3 + 4i) = " + module);

        MathFunc mathFunc = new MathFunc();
        double radius = 5.0;
        double circleLength = mathFunc.circleLength(radius);
        System.out.println("Длина окружности с радиусом " + radius + " = " + circleLength);

        double circleArea = mathFunc.circleArea(radius);
        System.out.println("Площадь круга с радиусом " + radius + " = " + circleArea);

        System.out.println("\n--- Задание 5-6: Stringable, ProcessStrings ---");

        Stringable processor = new ProcessStrings();
        String testString = "Hello World";

        System.out.println("Исходная строка: \"" + testString + "\"");

        int charCount = processor.countCharacters(testString);
        System.out.println("Количество символов: " + charCount);

        String oddChars = processor.getOddPositionCharacters(testString);
        System.out.println("Символы на нечетных позициях (1, 3, 5, ...): \"" + oddChars + "\"");

        String inverted = processor.invertString(testString);
        System.out.println("Инвертированная строка: \"" + inverted + "\"");

        System.out.println("\n--- Задание 7-8: Printable, Magazine, Book ---");

        Printable[] printables = new Printable[6];
        printables[0] = new Book("Война и мир");
        printables[1] = new Magazine("National Geographic");
        printables[2] = new Book("Преступление и наказание");
        printables[3] = new Magazine("Forbes");
        printables[4] = new Book("Мастер и Маргарита");
        printables[5] = new Magazine("Cosmopolitan");

        System.out.println("\nВсе издания:");
        for (Printable p : printables) {
            p.print();
        }

        Book.printBooks(printables);

        Magazine.printMagazines(printables);

        System.out.println("\n=== Все задания выполнены успешно! ===");
    }
}
