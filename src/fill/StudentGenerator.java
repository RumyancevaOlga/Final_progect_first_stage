package fill;

import model.Student;

import java.util.Random;

public class StudentGenerator {
    private static final Random RANDOM = new Random();
    public static Student randomStudent() {
        int groupNumber = RANDOM.nextInt(1, 100); // Случайный номер группы от 1 до 99
        double averageGrade = RANDOM.nextDouble(2, 5); // Случайный средний балл от 2 до 5
        int recordBookNumber = RANDOM.nextInt(100000, 1000000); // Случайный номер зачётки от 100000 до 999999
        return new Student.Builder()
                .groupNumber(groupNumber)
                .averageGrade(averageGrade)
                .recordBookNumber(recordBookNumber)
                .build();
    }
}
