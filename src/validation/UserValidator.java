package validation;

import model.User;

public class UserValidator implements Validator<User> {
    @Override
    public void validate(User user) throws ValidationException {
        // Проверка: имя не должно быть null или пустым
        if (user.getName() == null || user.getName().isBlank()) {
            throw new ValidationException("Имя не может быть пустым.");
        }

        // Проверка: имя должно содержать только буквы (латиница или кириллица) и пробелы, длина от 1 до 30 символов
        if (!user.getName().matches("[A-Za-zА-Яа-я\\s]{1,30}")) {
            throw new ValidationException("Имя должно содержать только буквы и быть длиной от 1 до 30 символов.");
        }

        // Проверка: пароль должен содержать не менее 6 символов
        if (user.getPassword().length() < 6) {
            throw new ValidationException("Пароль должен содержать минимум 6 символов.");
        }

        // Проверка: email должен соответствовать базовому шаблону электронной почты
        if (!user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new ValidationException("Неверный формат email.");
        }
    }
}
