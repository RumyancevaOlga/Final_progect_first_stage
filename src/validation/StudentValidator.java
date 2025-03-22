package validation;

import model.Student;

public class StudentValidator implements Validator<Student> {
    @Override
    public void validate(Student student) throws ValidationException {
        if (student.getGroupNumber() <= 0 || student.getGroupNumber() > 10) {
            throw new ValidationException("Номер группы должен быть положительным числом в дипазоне от 1 до 10.");
        }
        if (student.getAverageGrade() < 0.0 || student.getAverageGrade() > 5.0) {
            throw new ValidationException("Средний балл должен быть от 0 до 5.");
        }
        if (student.getRecordBookNumber() <= 0 || String.valueOf(student.getRecordBookNumber()).length() != 5) {
            throw new ValidationException("Номер зачетной книжки должен быть положительным пятизначным числом.");
        }
    }
}
