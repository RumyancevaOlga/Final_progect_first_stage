package display;

import collection.CustomArrayList;
import fill.InputHandler;
import fill.InputService;
import fill.file.BusFileInputHandler;
import fill.file.FileReaderCsv;
import fill.file.StudentFileInputHandler;
import fill.file.UserFileInputHandler;
import fill.manual.BusManualInputHandler;
import fill.manual.StudentManualInputHandler;
import fill.manual.UserManualInputHandler;
import model.Bus;
import model.Student;
import model.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private int size;
    private int fillMethod;
    private int dataType;

    public void menu() throws IOException {
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите способ заполнения массива:\n" +
                    "1 - заполнение из файла\n" +
                    "2 - ручной ввод\n" +
                    "3 - заполнение случайными значениями\n" +
                    "4 - выход из программы");

            try {
                fillMethod = in.nextInt();
                if (fillMethod == 4) System.exit(0);
                if (fillMethod > 4 | fillMethod <= 0) {
                    System.out.println("Неверный ввод. Введите число из предложенных.");
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите целое число из предложенных.");
                menu();
            }

            System.out.println("Введите желаемый размер массива (целое число)");

            try {
                size = in.nextInt();
                if (size <= 0) {
                    System.out.println("Неверный ввод. Размер массива не может быть меньше или равен нулю.");
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите целое число.");
                menu();
            }

            System.out.println("""
                    Введите желаемый тип данных:
                    1 - Автобус
                    2 - Студент
                    3 - Пользователь
                    """);
            try {
                dataType = in.nextInt();
                if (dataType <= 0 | dataType > 3) {
                    System.out.println("Неверный ввод. Введите число из предложенных.");
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите целое число");
                menu();
            }

            InputService inputService = new InputService();
            switch (fillMethod) {
                case 1:
                    FileReaderCsv fileReaderCsv = new FileReaderCsv();
                    System.out.println("Введите путь к файлу.");
                    String path = in.next();
                    fileReaderCsv.readFile(path);
                    switch (dataType) {
                        case 1:
                            BusFileInputHandler busFileInputHandler = new BusFileInputHandler();
                            busFileInputHandler.setFileReaderCsv(fileReaderCsv);
                            CustomArrayList<Bus> buses =  inputService.inputMultiple(busFileInputHandler, size);
                            for (Object bus : buses) System.out.println(bus);
                            break;
                        case 2:
                            StudentFileInputHandler studentFileInputHandler = new StudentFileInputHandler();
                            studentFileInputHandler.setFileReaderCsv(fileReaderCsv);
                            CustomArrayList<Student> students = inputService.inputMultiple(studentFileInputHandler, size);
                            for (Object student : students) System.out.println(student);
                            break;
                        case 3:
                            UserFileInputHandler userFileInputHandler = new UserFileInputHandler();
                            userFileInputHandler.setFileReaderCsv(fileReaderCsv);
                            CustomArrayList<User> users = inputService.inputMultiple(userFileInputHandler, size);
                            for (Object user : users) System.out.println(user);
                            break;
                    }
                    break;
                case 2:
                    switch (dataType) {
                        case 1:
                            BusManualInputHandler busManualInputHandler = new BusManualInputHandler();
                            CustomArrayList<Bus> buses =  inputService.inputMultiple(busManualInputHandler, size);
                            for (Object bus : buses) System.out.println(bus);
                            break;
                        case 2:
                            StudentManualInputHandler studentManualInputHandler = new StudentManualInputHandler();
                            CustomArrayList<Student> students = inputService.inputMultiple(studentManualInputHandler, size);
                            for (Object student : students) System.out.println(student);
                            break;
                        case 3:
                            UserManualInputHandler userManualInputHandler = new UserManualInputHandler();
                            CustomArrayList<User> users = inputService.inputMultiple(userManualInputHandler, size);
                            for (Object user : users) System.out.println(user);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("здесь тоже что-то будет");
                    break;
            }
        }
    }
}
