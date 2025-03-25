package fill.manual;

import fill.InputHandler;
import model.User;
import validation.*;

import java.util.Scanner;

public class UserManualInputHandler implements InputHandler<User> {
    private final Validator<User> validator = new UserValidator();

    @Override
    public User input() {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        String password = null;
        String email = null;
        while (true) {
            try {
                System.out.print("Введите имя (Только буквы, до 30 символов): ");
                name = scanner.nextLine().trim();

                System.out.print("Введите пароль (Не менее 6 символов): ");
                password = scanner.nextLine().trim();

                System.out.print("Введите email (В формате myemail@gmail.com): ");
                email = scanner.nextLine().trim();

                User user = new User.Builder().name(name).password(password).email(email).build();
                ValidationService.validateData(user, validator);

                return user;
            } catch (ValidationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидалось положительное число. Проверьте ввод.");
            }
        }
    }
}
