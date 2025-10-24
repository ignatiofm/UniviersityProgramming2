package ru.mirea.fedoseev.practice41.task7;

public class Schoolboy extends Pupil {
    private int grade;

    public Schoolboy(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String getType() {
        return "Школьник";
    }

    @Override
    public String toString() {
        return getType() + "{name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }
}
