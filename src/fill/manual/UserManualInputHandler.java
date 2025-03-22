package fill.manual;

import fill.InputHandler;
import model.Student;
import model.User;
import validation.*;

import java.util.Scanner;

public class UserManualInputHandler implements InputHandler<User> {
    private final Validator<User> validator = new UserValidator();

    @Override
    public User input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите имя (Только буквы, до 30 символов): ");
                String name = scanner.nextLine();

                System.out.print("Введите пароль (Не менее 6 символов): ");
                String password = scanner.nextLine();

                System.out.print("Введите email (В формате myemail@gmail.com): ");
                String email = scanner.nextLine();

                User user = new User.Builder().name(name).password(password).email(email).build();
                ValidationService.validateData(user, validator);

                return user;
            } catch (ValidationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
