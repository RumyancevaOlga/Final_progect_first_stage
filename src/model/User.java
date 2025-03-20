package model;

import java.util.Comparator;

public class User {
    private final String name;     // Имя
    private final String password; // Пароль
    private final String email;    // Почта

    // Приватный конструктор для Builder
    private User(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Статический метод для получения компаратора по имени
    public static Comparator<User> byName() {
        return Comparator.comparing(User::getName);
    }

    // Статический метод для получения компаратора по паролю
    public static Comparator<User> byPassword() {
        return Comparator.comparing(User::getPassword);
    }

    // Статический метод для получения компаратора по почте
    public static Comparator<User> byEmail() {
        return Comparator.comparing(User::getEmail);
    }

    // Реализация Builder
    public static class Builder {
        private String name;
        private String password;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}