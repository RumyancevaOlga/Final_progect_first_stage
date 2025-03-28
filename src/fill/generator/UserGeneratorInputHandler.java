package fill.generator;

import fill.InputHandler;
import model.User;

import java.util.Random;

public class UserGeneratorInputHandler implements InputHandler<User> {
    // Создаём объект класса "Random" для извлечения случайного значения из выбранного диапазона
    private static final Random RANDOM = new Random();

    private static final String[] NAMES = { // Создаём список имён
            "Harry", "James", "John", "William", "Robert", "Joseph",
            "Michael", "David", "Richard", "Charles", "Thomas", "Jack",
            "Mary", "Patricia", "Jennifer", "Elizabeth", "Linda", "Barbara",
            "Susan", "Margaret", "Jessica", "Sarah", "Lily", "Emily"};

    private static final String[] DOMAINS = { // Создаём список доменных имён
            "mail.ru", "bk.ru", "yandex.ru", "gmail.com",
            "yahoo.com", "icloud.com", "zoho.com", "outlook.com"};
    // Создаём список символов
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+<>?";
    // Метод для генерации случайных юзеров
    @Override
    public User input() { // Переопределяем метод "input" интерфейса "InputHandler"
        String name = NAMES[RANDOM.nextInt(NAMES.length)]; // Случайное имя из списка имён
        int lengthPass = RANDOM.nextInt(6, 12); // Случайная длина пароля от 6 до 12 символов
        // Собираем случайный пароль из элементов списка CHARACTERS
        StringBuilder password = new StringBuilder(lengthPass); // Создаём объект класса StringBuilder
        // Заполняем созданный объект случайными значениями из списка CHARACTERS
        // по одному пока не достигнем сгенерированной ранее длины пароля lengthPass
        for (int i = 0; i < lengthPass; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }
        // Собираем случайный email
        StringBuilder email = new StringBuilder(); // Создаём объект класса StringBuilder
        email.append(name); // Добавляем в него ранее выбранное имя пользователя
// Здесь можно добавить несколько случайных символов, если требуется больше уникальных значений
        email.append("@"); // Добавляем символ "@"
        email.append(DOMAINS[RANDOM.nextInt(DOMAINS.length)]); // Добавляем случайное доменное имя из списка DOMAINS

        return new User.Builder() // В итоге из полученных значений билдером собираем новый объект класса "User"
                .name(name)
                .password(password.toString())
                .email(email.toString())
                .build();
    }
}
