import collection.CustomArrayList;
import model.Bus;
import model.Student;
import model.User;
import sort.SelectionSort;
import validation.*;

public class Main {
    public static void main(String[] args) {
        // ----------- Buses -----------
        CustomArrayList<Bus> buses = new CustomArrayList<>();
        try {
            Bus b1 = new Bus.Builder().number(208).model("Reno").mileage(32400.1).build();
            ValidationService.validateData(b1, new BusValidator());
            buses.add(b1);

            Bus b2 = new Bus.Builder().number(103).model("Kia").mileage(14001.0).build();
            ValidationService.validateData(b2, new BusValidator());
            buses.add(b2);

            Bus b3 = new Bus.Builder().number(307).model("Volvo").mileage(25400.3).build();
            ValidationService.validateData(b3, new BusValidator());
            buses.add(b3);

            Bus b4 = new Bus.Builder().number(609).model("Exeed").mileage(5010.0).build();
            ValidationService.validateData(b4, new BusValidator());
            buses.add(b4);

            Bus b5 = new Bus.Builder().number(147).model("Mercedes").mileage(306120.0).build();
            ValidationService.validateData(b5, new BusValidator());
            buses.add(b5);

            Bus b6 = new Bus.Builder().number(222).model("Porsche").mileage(15000.5).build();
            ValidationService.validateData(b6, new BusValidator());
            buses.add(b6);

            Bus b7 = new Bus.Builder().number(510).model("Lada").mileage(21060.3).build();
            ValidationService.validateData(b7, new BusValidator());
            buses.add(b7);

            Bus b8 = new Bus.Builder().number(612).model("Lada").mileage(3004.12).build();
            ValidationService.validateData(b8, new BusValidator());
            buses.add(b8);
        } catch (ValidationException e) {
            System.err.println("Ошибка валидации автобуса: " + e.getMessage());
        }

        System.out.println("Автобусы до сортировки:");
        System.out.println(buses);
        SelectionSort.selectionSort(buses);
        System.out.println("\nАвтобусы после сортировки:");
        System.out.println(buses);

        // ----------- Students -----------
        CustomArrayList<Student> students = new CustomArrayList<>();
        try {
            Student s1 = new Student.Builder().groupNumber(1).averageGrade(4.5).recordBookNumber(23785).build();
            ValidationService.validateData(s1, new StudentValidator());
            students.add(s1);

            Student s2 = new Student.Builder().groupNumber(2).averageGrade(3.2).recordBookNumber(45678).build();
            ValidationService.validateData(s2, new StudentValidator());
            students.add(s2);

            Student s3 = new Student.Builder().groupNumber(3).averageGrade(4.7).recordBookNumber(12456).build();
            ValidationService.validateData(s3, new StudentValidator());
            students.add(s3);

            Student s4 = new Student.Builder().groupNumber(3).averageGrade(3.0).recordBookNumber(56748).build();
            ValidationService.validateData(s4, new StudentValidator());
            students.add(s4);
        } catch (ValidationException e) {
            System.err.println("Ошибка валидации студента: " + e.getMessage());
        }

        System.out.println("\nСтуденты до сортировки:");
        System.out.println(students);
        SelectionSort.selectionSort(students);
        System.out.println("\nСтуденты после сортировки:");
        System.out.println(students);

        // ----------- Users -----------
        CustomArrayList<User> users = new CustomArrayList<>();
        try {
            User u1 = new User.Builder().name("Alina").password("Password123").email("AlinaLina@yandex.ru").build();
            ValidationService.validateData(u1, new UserValidator());
            users.add(u1);

            User u2 = new User.Builder().name("Ivan").password("MyPassword").email("IvanKugrashov1987@gmail.com").build();
            ValidationService.validateData(u2, new UserValidator());
            users.add(u2);

            User u3 = new User.Builder().name("Marya").password("PasswordMy").email("LukretskayaMaria98@rambler.com").build();
            ValidationService.validateData(u3, new UserValidator());
            users.add(u3);

            User u4 = new User.Builder().name("Vasya").password("MyUniqPassword").email("Vasilii1995@mail.ru").build();
            ValidationService.validateData(u4, new UserValidator());
            users.add(u4);
        } catch (ValidationException e) {
            System.err.println("Ошибка валидации пользователя: " + e.getMessage());
        }

        System.out.println("\nПользователи до сортировки:");
        System.out.println(users);
        SelectionSort.selectionSort(users);
        System.out.println("\nПользователи после сортировки:");
        System.out.println(users);
    }
}
