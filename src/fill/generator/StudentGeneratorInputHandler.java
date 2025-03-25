package fill.generator;

import fill.InputHandler;
import model.Student;

import java.util.Random;

public class StudentGeneratorInputHandler implements InputHandler<Student> {
    private static final Random RANDOM = new Random();

    @Override
    public Student input() {
        int groupNumber = RANDOM.nextInt(1, 100); // Случайный номер группы от 1 до 99
        double averageGrade = RANDOM.nextDouble(2, 5); // Случайный средний балл от 2 до 5
        averageGrade = Math.round(averageGrade * 10) / 10.0; // Округление до одного знака после запятой
        int recordBookNumber = RANDOM.nextInt(10000, 100000); // Случайный номер зачётки от 100000 до 999999
        return new Student.Builder()
                .groupNumber(groupNumber)
                .averageGrade(averageGrade)
                .recordBookNumber(recordBookNumber)
                .build();
    }
}
