package ru.mirea.fedoseev.practice13;

public class Student implements Comparable<Student> {
    private int iDNumber;
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(int iDNumber, String firstName, String lastName, double gpa) {
        this.iDNumber = iDNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
