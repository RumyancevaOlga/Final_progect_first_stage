package fill.manual;

import fill.InputHandler;
import model.User;
import validation.*;

import java.util.Scanner;

public class UserManualInputHandler implements InputHandler<User> {
    // Используем интерфейс Validator с реализацией для User
    private final Validator<User> validator = new UserValidator();

    @Override
    public User input() {
        Scanner scanner = new Scanner(System.in);

        // Главный цикл: продолжается до тех пор, пока пользователь не введёт корректные данные
        while (true) {
            try {
                // Ввод имени пользователя
                System.out.print("Введите имя (Только буквы, до 30 символов): ");
                String name = scanner.nextLine().trim();

                // Ввод пароля
                System.out.print("Введите пароль (Не менее 6 символов): ");
                String password = scanner.nextLine().trim();

                // Ввод электронной почты
                System.out.print("Введите email (В формате myemail@gmail.com): ");
                String email = scanner.nextLine().trim();

                // Создание объекта User с использованием шаблона Builder
                User user = new User.Builder()
                        .name(name)
                        .password(password)
                        .email(email)
                        .build();

                // Проверка корректности введённых данных через сервис валидации
                ValidationService.validateData(user, validator);

                return user;

            } catch (ValidationException e) {
                // Обработка ошибок валидации
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                // Этот блок на всякий случай: может быть полезен, если поля поменяются на числовые
                System.out.println("Ошибка: ожидалось положительное число. Проверьте ввод.\nДля ввода дробных чисел используйте точку (например, 123.45).");
            }
        }
    }
}
