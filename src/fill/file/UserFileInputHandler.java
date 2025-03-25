package fill.file;

import fill.InputHandler;
import model.User;
import validation.*;

public class UserFileInputHandler implements InputHandler<User> {

    private final Validator<User> validator = new UserValidator();
    private String[] line;

    public UserFileInputHandler (String[] line) {this.line = line;}

    @Override
    public User input() {

        try {
            User user = new User.Builder()
                    .name(line[0])
                    .password(line[1])
                    .email(line[2])
                    .build();
            ValidationService.validateData(user, validator);
            return user;
        } catch (ValidationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
