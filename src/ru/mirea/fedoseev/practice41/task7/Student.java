package ru.mirea.fedoseev.practice41.task7;

public class Student extends Pupil {
    private String university;
    private int course;

    public Student(String name, int age, String university, int course) {
        super(name, age);
        this.university = university;
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String getType() {
        return "Студент";
    }

    @Override
    public String toString() {
        return getType() + "{name='" + name + "', age=" + age +
               ", university='" + university + "', course=" + course + "}";
    }
}
