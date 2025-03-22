import collection.CustomArrayList;
import model.Bus;
import model.Student;
import model.User;
import sort.SelectionSort;


public class Main {
    public static void main(String[] args) {
        // Создаем CustomArrayList для хранения объектов Bus
        CustomArrayList<Bus> buses = new CustomArrayList<>();
        // Создаем объекты Bus с разными значениями
        buses.add(new Bus.Builder().number(208).model("Reno").mileage(32400.1).build());
        buses.add(new Bus.Builder().number(103).model("Kia").mileage(14001.0).build());
        buses.add(new Bus.Builder().number(307).model("Volvo").mileage(25400.3).build());
        buses.add(new Bus.Builder().number(609).model("Exeed").mileage(5010.0).build());
        buses.add(new Bus.Builder().number(147).model("Mercedes").mileage(306120.0).build());
        buses.add(new Bus.Builder().number(222).model("Porsche").mileage(15000.5).build());
        buses.add(new Bus.Builder().number(510).model("Lada").mileage(21060.3).build());
        buses.add(new Bus.Builder().number(612).model("Lada").mileage(3004.12).build());
        buses.add(new Bus.Builder().number(208).model("Reno").mileage(32400.1).build());
        // Выводим список до сортировки
        System.out.println("Автобусы до сортировки:");
        System.out.println(buses);
        // Выполняем сортировку с использованием SelectionSort
        SelectionSort.selectionSort(buses);
        // Выводим список после сортировки
        System.out.println("\nАвтобусы после сортировки:");
        System.out.println(buses);

        // Пример для Student
        CustomArrayList<Student> students = new CustomArrayList<>();
        students.add(new Student.Builder().groupNumber(1).averageGrade(4.5).recordBookNumber(23785).build());
        students.add(new Student.Builder().groupNumber(2).averageGrade(3.2).recordBookNumber(45678).build());
        students.add(new Student.Builder().groupNumber(3).averageGrade(4.7).recordBookNumber(12456).build());
        students.add(new Student.Builder().groupNumber(3).averageGrade(3.0).recordBookNumber(56748).build());
        System.out.println("Студенты до сортировки:");
        System.out.println(students);
        SelectionSort.selectionSort(students);
        System.out.println("\nСтуденты после сортировки:");
        System.out.println(students);

        // Пример для User
        CustomArrayList<User> users = new CustomArrayList<>();
        users.add(new User.Builder().name("Alina").password("Password123").email("AlinaLina@yandex.ru").build());
        users.add(new User.Builder().name("Ivan").password("MyPassword").email("IvanKugrashov1987@gmail.com").build());
        users.add(new User.Builder().name("Marya").password("PasswordMy").email("LukretskayaMaria98@rambler.com").build());
        users.add(new User.Builder().name("Vasya").password("MyUniqPassword").email("Vasilii1995@mail.ru").build());
        System.out.println("\nПользователи до сортировки:");
        System.out.println(users);
        SelectionSort.selectionSort(users);
        System.out.println("\nПользователи после сортировки:");
        System.out.println(users);
    }
}
