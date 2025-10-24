package ru.mirea.fedoseev.practice41.task7;

public class Pupil {
    protected String name;
    protected int age;

    public Pupil(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getType() {
        return "Учащийся";
    }

    @Override
    public String toString() {
        return getType() + "{name='" + name + "', age=" + age + "}";
    }
}
