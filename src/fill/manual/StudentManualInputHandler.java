package fill.manual;

import fill.InputHandler;
import model.Student;
import validation.*;

import java.util.Scanner;

public class StudentManualInputHandler implements InputHandler<Student> {
    // Используем интерфейс Validator с конкретной реализацией StudentValidator
    private final Validator<Student> validator = new StudentValidator();

    @Override
    public Student input() {
        Scanner scanner = new Scanner(System.in);

        // Главный цикл: продолжается до тех пор, пока пользователь не введёт корректные данные
        while (true) {
            try {
                // Ввод и парсинг номера группы
                System.out.print("Введите номер группы (Целое число от 1 до 99): ");
                int groupNumber = Integer.parseInt(scanner.nextLine());

                // Ввод и парсинг среднего балла
                System.out.print("Введите средний балл (Число от 1 до 5): ");
                double averageGrade = Double.parseDouble(scanner.nextLine());

                // Ввод и парсинг номера зачетной книжки
                System.out.print("Введите номер зачетной книжки (Пятизначное целое положительное число): ");
                int recordBookNumber = Integer.parseInt(scanner.nextLine());

                // Создание объекта Student с использованием билдера
                Student student = new Student.Builder()
                        .groupNumber(groupNumber)
                        .averageGrade(averageGrade)
                        .recordBookNumber(recordBookNumber)
                        .build();

                // Валидация введённых данных с использованием общего сервиса
                ValidationService.validateData(student, validator);

                return student;

            } catch (ValidationException e) {
                // Обработка ошибок валидации
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                // Обработка ошибок преобразования строк в числа
                System.out.println("Ошибка: ожидалось положительное число. Проверьте ввод.");
            }
        }
    }
}
