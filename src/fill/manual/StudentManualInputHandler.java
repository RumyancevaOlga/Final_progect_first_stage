package fill.manual;

import fill.InputHandler;
import model.Student;
import validation.*;

import java.util.Scanner;

public class StudentManualInputHandler implements InputHandler<Student> {
    private final Validator<Student> validator = new StudentValidator();

    @Override
    public Student input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите номер группы (Целое число от 1 до 10): ");
                int groupNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите средний балл (Число от 1 до 5): ");
                double averageGrade = Double.parseDouble(scanner.nextLine());

                System.out.print("Введите номер зачетной книжки (Пятизначное целое положительное число): ");
                int recordBookNumber = Integer.parseInt(scanner.nextLine());

                Student student = new Student.Builder().groupNumber(groupNumber).averageGrade(averageGrade).recordBookNumber(recordBookNumber).build();
                ValidationService.validateData(student, validator);

                return student;
            } catch (ValidationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ожидалось число, перепроверьте ввод.");
            }
        }
    }
}
