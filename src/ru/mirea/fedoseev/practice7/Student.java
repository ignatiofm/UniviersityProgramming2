package ru.mirea.fedoseev.practice7;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Задание 3. Класс Student с полем для хранения даты рождения
 * и методом toString() с форматированием даты.
 */
public class Student {
    private String name;
    private Date birthDate;
    private int studentId;

    public Student(String name, Date birthDate, int studentId) {
        this.name = name;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getStudentId() {
        return studentId;
    }

    /**
     * Возвращает строковое представление даты рождения в указанном формате.
     * @param format формат даты: "SHORT" - краткий, "MEDIUM" - средний, "LONG" - полный
     * @return отформатированная строка с датой рождения
     */
    public String getBirthDateFormatted(String format) {
        SimpleDateFormat dateFormat;

        switch (format.toUpperCase()) {
            case "SHORT":
                dateFormat = new SimpleDateFormat("dd.MM.yy");
                break;
            case "MEDIUM":
                dateFormat = new SimpleDateFormat("dd MMM yyyy");
                break;
            case "LONG":
                dateFormat = new SimpleDateFormat("dd MMMM yyyy 'года'");
                break;
            default:
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                break;
        }

        return dateFormat.format(birthDate);
    }

    @Override
    public String toString() {
        return toString("MEDIUM");
    }

    /**
     * Возвращает строковое представление студента с форматированной датой рождения.
     * @param dateFormat формат даты: "SHORT", "MEDIUM", "LONG"
     * @return строковое представление студента
     */
    public String toString(String dateFormat) {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + getBirthDateFormatted(dateFormat) +
                ", studentId=" + studentId +
                '}';
    }
}
