package fill.file;

import fill.InputHandler;
import model.Student;
import validation.*;

public class StudentFileInputHandler implements InputHandler<Student> {

    private final Validator<Student> validator = new StudentValidator();
    private String[] line;

    public StudentFileInputHandler (String[] line) {this.line = line;}

    @Override
    public Student input() {

        try {
            Student student = new Student.Builder()
                    .groupNumber(Integer.parseInt(line[0]))
                    .averageGrade(Double.parseDouble(line[1]))
                    .recordBookNumber(Integer.parseInt(line[2]))
                    .build();
            ValidationService.validateData(student, validator);
            return student;
        } catch (ValidationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
