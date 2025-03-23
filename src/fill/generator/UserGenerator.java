package fill.generator;

import model.User;

import java.util.Random;

public class UserGenerator {
    private static final Random RANDOM = new Random();
//    Создаём список имён
    private static final String[] NAMES = {
            "Harry", "James", "John", "William", "Robert", "Joseph",
            "Michael", "David", "Richard", "Charles", "Thomas", "Jack",
            "Mary", "Patricia", "Jennifer", "Elizabeth", "Linda", "Barbara",
            "Susan", "Margaret", "Jessica", "Sarah", "Lily", "Emily"};
//    Создаём список доменов
    private static final String[] DOMAINS = {
            "mail.ru", "bk.ru", "yandex.ru", "gmail.com",
            "yahoo.com", "icloud.com", "zoho.com", "outlook.com"};
//    Создаём список символов
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+<>?";
//    Метод для генерации случайных юзеров
    public static User randomUser() {
        String name = NAMES[RANDOM.nextInt(NAMES.length)]; // Случайное имя из списка имён
        int lengthPass = RANDOM.nextInt(6, 12); // Случайная длина пароля от 6 до 12 символов
        StringBuilder password = new StringBuilder(lengthPass); // Собираем случайный пароль из элементов списка CHARACTERS
        for (int i = 0; i < lengthPass; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }
        StringBuilder email = new StringBuilder(); // Собираем случайный email
        email.append(name);
//        Здесь можно добавить несколько случайных символов
        email.append("@");
        email.append(DOMAINS[RANDOM.nextInt(DOMAINS.length)]);

        return new User.Builder()
                .name(name)
                .password(password.toString())
                .email(email.toString())
                .build();
    }
}
