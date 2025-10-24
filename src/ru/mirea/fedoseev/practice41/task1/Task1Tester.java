package ru.mirea.fedoseev.practice41.task1;

public class Task1Tester {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5.0, "RED", true);
        Shape shape2 = new Rectangle(4.0, 6.0, "BLUE", false);
        Shape shape3 = new Square(3.0, "GREEN", true);

        System.out.println("=== Демонстрация полиморфизма ===");
        System.out.println();

        System.out.println("Circle (через ссылку Shape):");
        System.out.println(shape1);
        System.out.println("Type: " + shape1.getType());
        System.out.println("Area: " + shape1.getArea());
        System.out.println("Perimeter: " + shape1.getPerimeter());
        System.out.println("Color: " + shape1.getColor());
        System.out.println("Filled: " + shape1.isFilled());
        System.out.println();

        System.out.println("Rectangle (через ссылку Shape):");
        System.out.println(shape2);
        System.out.println("Type: " + shape2.getType());
        System.out.println("Area: " + shape2.getArea());
        System.out.println("Perimeter: " + shape2.getPerimeter());
        System.out.println("Color: " + shape2.getColor());
        System.out.println("Filled: " + shape2.isFilled());
        System.out.println();

        System.out.println("Square (через ссылку Shape):");
        System.out.println(shape3);
        System.out.println("Type: " + shape3.getType());
        System.out.println("Area: " + shape3.getArea());
        System.out.println("Perimeter: " + shape3.getPerimeter());
        System.out.println("Color: " + shape3.getColor());
        System.out.println("Filled: " + shape3.isFilled());
        System.out.println();

        System.out.println("=== Объяснение работы программы ===");
        System.out.println("Используется полиморфизм: переменные типа Shape");
        System.out.println("ссылаются на объекты подклассов (Circle, Rectangle, Square).");
        System.out.println("При вызове методов getType(), getArea(), getPerimeter()");
        System.out.println("вызываются переопределенные версии из подклассов,");
        System.out.println("а не из родительского класса Shape.");
        System.out.println("Это демонстрирует динамическое связывание в Java.");
    }
}
