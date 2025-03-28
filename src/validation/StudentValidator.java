package validation;

import model.Student;

public class StudentValidator implements Validator<Student> {
    @Override
    public void validate(Student student) throws ValidationException {
        // Проверка: номер группы должен быть от 1 до 99 включительно
        if (student.getGroupNumber() <= 0 || student.getGroupNumber() >= 100) {
            throw new ValidationException("Номер группы должен быть положительным числом в диапазоне от 1 до 99.");
        }

        // Проверка: средний балл должен быть в пределах от 0.0 до 5.0
        if (student.getAverageGrade() < 0.0 || student.getAverageGrade() > 5.0) {
            throw new ValidationException("Средний балл должен быть от 0 до 5.");
        }

        // Проверка: номер зачётной книжки должен быть положительным пятизначным числом
        int recordBookNumber = student.getRecordBookNumber();
        if (recordBookNumber <= 0 || String.valueOf(recordBookNumber).length() != 5) {
            throw new ValidationException("Номер зачётной книжки должен быть положительным целым пятизначным числом.");
        }
    }
}
