package ru.mirea.fedoseev.practice41.task7;

public class PupilTester {
    public static void main(String[] args) {
        Pupil[] pupils = {
            new Schoolboy("Иван Петров", 14, 8),
            new Student("Мария Сидорова", 20, "МГУ", 3),
            new Schoolboy("Алексей Иванов", 16, 10),
            new Student("Анна Кузнецова", 19, "МФТИ", 2),
            new Schoolboy("Петр Смирнов", 12, 6),
            new Student("Дмитрий Попов", 21, "МИФИ", 4)
        };

        System.out.println("=== Все учащиеся ===");
        for (Pupil pupil : pupils) {
            System.out.println(pupil);
        }
        System.out.println();

        System.out.println("=== Школьники ===");
        for (Pupil pupil : pupils) {
            if (pupil instanceof Schoolboy) {
                System.out.println(pupil);
            }
        }
        System.out.println();

        System.out.println("=== Студенты ===");
        for (Pupil pupil : pupils) {
            if (pupil instanceof Student) {
                System.out.println(pupil);
            }
        }
    }
}
