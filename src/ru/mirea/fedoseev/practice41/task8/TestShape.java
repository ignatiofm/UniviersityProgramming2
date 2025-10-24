package ru.mirea.fedoseev.practice41.task8;

public class TestShape {
    public static void main(String[] args) {
        System.out.println("=== Упражнение 1: Тестирование полиморфизма ===\n");

        System.out.println("1. Upcast Circle to Shape:");
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());
        // System.out.println(s1.getRadius()); // ОШИБКА! У Shape нет метода getRadius()
        System.out.println();

        System.out.println("2. Downcast back to Circle:");
        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Color: " + c1.getColor());
        System.out.println("Filled: " + c1.isFilled());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println();

        System.out.println("3. Попытка создать объект Shape:");
        // Shape s2 = new Shape();  // ОШИБКА КОМПИЛЯЦИИ! Нельзя создать объект абстрактного класса
        System.out.println("ОШИБКА: Cannot instantiate the type Shape");
        System.out.println("Абстрактные классы не могут иметь экземпляров\n");

        System.out.println("4. Upcast Rectangle to Shape:");
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println("Area: " + s3.getArea());
        System.out.println("Perimeter: " + s3.getPerimeter());
        System.out.println("Color: " + s3.getColor());
        // System.out.println(s3.getLength());  // ОШИБКА! У Shape нет getLength()
        System.out.println();

        System.out.println("5. Downcast to Rectangle:");
        Rectangle r1 = (Rectangle)s3;
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Color: " + r1.getColor());
        System.out.println("Length: " + r1.getLength());
        System.out.println();

        System.out.println("6. Upcast Square to Shape:");
        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println("Area: " + s4.getArea());
        System.out.println("Color: " + s4.getColor());
        // System.out.println(s4.getSide());  // ОШИБКА! У Shape нет getSide()
        System.out.println();

        System.out.println("7. Downcast Shape s4 к Rectangle:");
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println("Area: " + r2.getArea());
        System.out.println("Color: " + r2.getColor());
        // System.out.println(r2.getSide());  // ОШИБКА! У Rectangle нет getSide()
        System.out.println("Length: " + r2.getLength());
        System.out.println();

        System.out.println("8. Downcast Rectangle r2 к Square:");
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Color: " + sq1.getColor());
        System.out.println("Side: " + sq1.getSide());
        System.out.println("Length: " + sq1.getLength());
        System.out.println();

        System.out.println("=== Объяснение ===");
        System.out.println("1. Upcast (восходящее приведение) всегда безопасно");
        System.out.println("2. При вызове методов через ссылку Shape вызываются переопределенные");
        System.out.println("   версии из подклассов (динамическое связывание)");
        System.out.println("3. Downcast (нисходящее приведение) требует явного приведения типа");
        System.out.println("4. Нельзя создать объект абстрактного класса");
        System.out.println("5. Методы, доступные через ссылку, определяются типом ссылки,");
        System.out.println("   а не типом объекта");
    }
}
