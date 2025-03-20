package model;

import java.util.Comparator;

public class Bus {
    private final int number;       // Номер
    private final String model;     // Модель
    private final double mileage;   // Пробег

    // Приватный конструктор для Builder
    private Bus(Builder builder) {
        this.number = builder.number;
        this.model = builder.model;
        this.mileage = builder.mileage;
    }

    // Геттеры
    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getMileage() {
        return mileage;
    }

    // Статический метод для получения компаратора по номеру
    public static Comparator<Bus> byNumber() {
        return Comparator.comparingInt(Bus::getNumber);
    }

    // Статический метод для получения компаратора по модели
    public static Comparator<Bus> byModel() {
        return Comparator.comparing(Bus::getModel);
    }

    // Статический метод для получения компаратора по пробегу
    public static Comparator<Bus> byMileage() {
        return Comparator.comparingDouble(Bus::getMileage);
    }

    // Реализация Builder
    public static class Builder {
        private int number;
        private String model;
        private double mileage;

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder mileage(double mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "Bus{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}