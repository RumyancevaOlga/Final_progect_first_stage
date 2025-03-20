package model;

import java.util.Comparator;

public class Student {
    private final int groupNumber;       // Номер группы
    private final double averageGrade;   // Средний балл
    private final int recordBookNumber;  // Номер зачетной книжки

    // Приватный конструктор для Builder
    private Student(Builder builder) {
        this.groupNumber = builder.groupNumber;
        this.averageGrade = builder.averageGrade;
        this.recordBookNumber = builder.recordBookNumber;
    }

    // Геттеры
    public int getGroupNumber() {
        return groupNumber;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    // Статический метод для получения компаратора по номеру группы
    public static Comparator<Student> byGroupNumber() {
        return Comparator.comparingInt(Student::getGroupNumber);
    }

    // Статический метод для получения компаратора по среднему баллу
    public static Comparator<Student> byAverageGrade() {
        return Comparator.comparingDouble(Student::getAverageGrade);
    }

    // Статический метод для получения компаратора по номеру зачетной книжки
    public static Comparator<Student> byRecordBookNumber() {
        return Comparator.comparingInt(Student::getRecordBookNumber);
    }

    // Реализация Builder
    public static class Builder {
        private int groupNumber;
        private double averageGrade;
        private int recordBookNumber;

        public Builder groupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder averageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public Builder recordBookNumber(int recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "Student{" +
                "groupNumber=" + groupNumber +
                ", averageGrade=" + averageGrade +
                ", recordBookNumber=" + recordBookNumber +
                '}';
    }
}