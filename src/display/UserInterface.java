package display;

import collection.CustomArrayList;
import fill.file.StudentFileInputHandler;
import fill.file.UserFileInputHandler;
import generator.DataGenerators;
import fill.file.BusFileInputHandler;
import fill.manual.BusManualInputHandler;
import fill.manual.StudentManualInputHandler;
import fill.manual.UserManualInputHandler;
import model.Bus;
import model.Student;
import model.User;
import sort.BinarySearch;
import sort.SelectionSort;
import strategy.DataFillingStrategy;
import strategy.FileFillingStrategy;
import strategy.ManualFillingStrategy;
import strategy.RandomFillingStrategy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private CustomArrayList<?> currentData;
    private int currentDataType;

    public void menu() throws IOException {
        
        while (true) {
            printMainMenu();
            int choice = readIntInput("Выберите действие: ", 1, 5);

            switch (choice) {
                case 1 -> fillDataMenu();
                case 2 -> performSorting();
                case 3 -> performSearch();
                case 4 -> printCurrentData();
                case 5 -> {
                    System.out.println("Выход из программы...");
                    System.exit(0);
                }
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Заполнить массив данных");
        System.out.println("2. Отсортировать данные");
        System.out.println("3. Найти элемент");
        System.out.println("4. Вывести текущие данные");
        System.out.println("5. Выйти из программы");
    }

    private void fillDataMenu() {
        System.out.println("\n=== Выбор типа данных ===");
        System.out.println("1. Автобусы (Bus)");
        System.out.println("2. Студенты (Student)");
        System.out.println("3. Пользователи (User)");
        System.out.println("4. Назад");

        currentDataType = readIntInput("Выберите тип данных: ", 1, 4);
        if (currentDataType == 4) return;

        System.out.println("\n=== Способ заполнения ===");
        System.out.println("1. Ввести данные вручную");
        System.out.println("2. Загрузить из файла");
        System.out.println("3. Сгенерировать случайные данные");
        System.out.println("4. Назад");

        int fillMethod = readIntInput("Выберите способ заполнения: ", 1, 4);
        if (fillMethod == 4) return;

        int size = readIntInput("Укажите количество элементов: ", 1, Integer.MAX_VALUE);

        String filePath = null;
        if (fillMethod == 2) {
            filePath = readFilePath();
        }

        switch (currentDataType) {
            case 1 -> currentData = fillBusData(fillMethod, size, filePath);
            case 2 -> currentData = fillStudentData(fillMethod, size, filePath);
            case 3 -> currentData = fillUserData(fillMethod, size, filePath);
        }
        printCurrentData();
        askForNextAction();
    }

    private void askForNextAction() {
        System.out.println("\nЧто вы хотите сделать дальше?");
        System.out.println("1. Отсортировать данные");
        System.out.println("2. Найти элемент");
        System.out.println("3. Вернуться в главное меню");

        int choice = readIntInput("Выберите действие: ", 1, 3);
        switch (choice) {
            case 1 -> performSorting();
            case 2 -> performSearch();
            case 3 -> {}
        }
    }

    private void performSorting() {
        if (checkEmptyData()) return;
        sortCurrentData();
        printCurrentData();
        askForNextAction();
    }


    private void performSearch() {
        if (checkEmptyData()) return;
        searchCurrentData();
        askForNextAction();
    }

    private void sortCurrentData() {
        switch (currentDataType) {
            case 1 -> SelectionSort.selectionSort((CustomArrayList<Bus>) currentData);
            case 2 -> SelectionSort.selectionSort((CustomArrayList<Student>) currentData);
            case 3 -> SelectionSort.selectionSort((CustomArrayList<User>) currentData);
        }
    }

    private void searchCurrentData() {
        switch (currentDataType) {
            case 1 -> {
                Bus bus = createBusManually();
                int index = BinarySearch.binarySearch((CustomArrayList<Bus>) currentData, bus);
                printSearchResult(index, bus);
            }
            case 2 -> {
                Student student = createStudentManually();
                int index = BinarySearch.binarySearch((CustomArrayList<Student>) currentData, student);
                printSearchResult(index, student);
            }
            case 3 -> {
                User user = createUserManually();
                int index = BinarySearch.binarySearch((CustomArrayList<User>) currentData, user);
                printSearchResult(index, user);
            }
        }
    }

    private <T> void printSearchResult(int index, T element) {
        if (index >= 0) {
            System.out.println("\nЭлемент найден на позиции: " + index);
            System.out.println("Найденный элемент: " + element);
        } else {
            System.out.println("\nЭлемент не найден в массиве");
        }
    }

    private boolean checkEmptyData() {
        if (currentData == null || currentData.isEmpty()) {
            System.out.println("Нет данных для операции. Сначала заполните массив.");
            return true;
        }
        return false;
    }

    private void printCurrentData() {
        System.out.println("\n=== Текущие данные ===");
        currentData.forEach(System.out::println);
    }

    private CustomArrayList<Bus> fillBusData(int method, int size, String filePath) {
        Map<Integer, DataFillingStrategy<Bus>> strategies = new HashMap<>();
        strategies.put(1, new ManualFillingStrategy<>(this::createBusManually));
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new BusFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(DataGenerators.BusGenerator::randomBus));

        return strategies.get(method).fillData(size);
    }

    private CustomArrayList<Student> fillStudentData(int method, int size, String filePath) {
        Map<Integer, DataFillingStrategy<Student>> strategies = new HashMap<>();
        strategies.put(1, new ManualFillingStrategy<>(this::createStudentManually));
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new StudentFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(DataGenerators.StudentGenerator::randomStudent));

        return strategies.get(method).fillData(size);
    }

    private CustomArrayList<User> fillUserData(int method, int size, String filePath) {
        Map<Integer, DataFillingStrategy<User>> strategies = new HashMap<>();
        strategies.put(1, new ManualFillingStrategy<>(this::createUserManually));
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new UserFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(DataGenerators.UserGenerator::randomUser));

        return strategies.get(method).fillData(size);
    }

    private Bus createBusManually() {
        BusManualInputHandler busManualInputHandler = new BusManualInputHandler();
        return busManualInputHandler.input();
    }

    private Student createStudentManually() {
        StudentManualInputHandler studentManualInputHandler = new StudentManualInputHandler();
        return studentManualInputHandler.input();
    }

    private User createUserManually() {
        UserManualInputHandler userManualInputHandler = new UserManualInputHandler();
        return userManualInputHandler.input();
    }

    private int readIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Ошибка: введите число от " + min + " до " + max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    private double readDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Ошибка: введите число от " + min + " до " + max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число");
            }
        }
    }

    private String readFilePath() {
        System.out.print("Введите путь к файлу: ");
        return scanner.nextLine();
    }
}
