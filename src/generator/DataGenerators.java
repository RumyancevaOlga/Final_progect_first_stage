package generator;



import fill.generator.BusGeneratorInputHandler;
import fill.generator.StudentGeneratorInputHandler;
import fill.generator.UserGeneratorInputHandler;
import model.Bus;
import model.Student;
import model.User;

import java.util.Random;

// DataGenerators.java
public final class DataGenerators {
    private static final Random RANDOM = new Random();

    private DataGenerators() {}

    public static class BusGenerator {
        public static Bus randomBus() {
            return new BusGeneratorInputHandler().input();
        }
    }

    public static class StudentGenerator {
        public static Student randomStudent() {
            return new StudentGeneratorInputHandler().input();
        }
    }

    public static class UserGenerator {
        public static User randomUser() {
            return new UserGeneratorInputHandler().input();
        }

    }
}