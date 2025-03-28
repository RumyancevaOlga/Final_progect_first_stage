package display;

import algorithms.CustomSort;
import collection.CustomArrayList;
import fill.file.StudentFileInputHandler;
import fill.file.UserFileInputHandler;
import fill.file.BusFileInputHandler;
import fill.generator.BusGeneratorInputHandler;
import fill.generator.StudentGeneratorInputHandler;
import fill.generator.UserGeneratorInputHandler;
import fill.manual.BusManualInputHandler;
import fill.manual.StudentManualInputHandler;
import fill.manual.UserManualInputHandler;
import model.Bus;
import model.Student;
import model.User;
import algorithms.BinarySearch;
import algorithms.SelectionSort;
import record.FileRecordAdd;
import strategy.DataFillingStrategy;
import strategy.FileFillingStrategy;
import strategy.ManualFillingStrategy;
import strategy.RandomFillingStrategy;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in); // Чтение ввода пользователя
    private CustomArrayList<?> currentData; // Текущий набор данных (Bus/Student/User)
    private int currentDataType;  // Тип данных (1-Bus, 2-Student, 3-User)
    private boolean isRunning = true;  // Флаг работы программы
    private boolean isSorted = false; // Флаг на сортировку
    private boolean isDefaultSorted = false;
    private int searchResult = -2; // Флаг на поиск

    public void menu() throws IOException {
        while (isRunning) {  // Главный цикл программы
            printMainMenu(); // Вывод меню
            int choice = readIntInput("Выберите действие: ", 1, 4); // Чтение выбора пользователя
            switch (choice) {  // Обработка выбора
                case 1 -> fillDataMenu();    // Заполнение данных
                case 2 -> performSorting();  // Сортировка
                case 3 -> performSearch();  // Поиск
                case 4 -> exitProgram();    // Выход
            }
        }
    }

    private void exitProgram() {
        isRunning = false; //Остановка цикла
        scanner.close(); // Закрытие Scanner
        System.out.println("Программа завершена");
    }

    private void printMainMenu() {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Заполнить массив данных");
        System.out.println("2. Отсортировать данные");
        System.out.println("3. Найти элемент");
        System.out.println("4. Выйти из программы");
    }

    private void fillDataMenu() throws IOException {
        System.out.println("\n=== Выбор типа данных ===");
        System.out.println("1. Автобусы (Bus)");
        System.out.println("2. Студенты (Student)");
        System.out.println("3. Пользователи (User)");
        System.out.println("4. Назад");

        // Выбор типа данных
        currentDataType = readIntInput("Выберите тип данных: ", 1, 4);
        if (currentDataType == 4) return; // Выход, если выбран "Назад"

        System.out.println("\n=== Способ заполнения ===");
        System.out.println("1. Ввести данные вручную");
        System.out.println("2. Загрузить из файла");
        System.out.println("3. Сгенерировать случайные данные");
        System.out.println("4. Назад");

        // Выбор способа заполнения
        int fillMethod = readIntInput("Выберите способ заполнения: ", 1, 4);
        if (fillMethod == 4) return;

        // Указание размера
        int size = readIntInput("Укажите количество элементов: ", 1, Integer.MAX_VALUE);

        // Чтение пути к файлу
        String filePath = null;
        if (fillMethod == 2) {
            filePath = readFilePath();
        }

        // Заполнение данных
        //Методы fillBusData() / fillStudentData() / fillUserData()
        // используют стратегии ManualFillingStrategy, FileFillingStrategy и RandomFillingStrategy
        switch (currentDataType) {
            case 1 -> currentData = fillBusData(fillMethod, size, filePath);
            case 2 -> currentData = fillStudentData(fillMethod, size, filePath);
            case 3 -> currentData = fillUserData(fillMethod, size, filePath);
        }
        if (size > currentData.size()) System.out.printf("В файле недостаточно данных. Размер полученного массива: " +
                "%d", currentData.size());
        printCurrentData(); // Вывод данных на экран
        askForNextAction(); //Спрашиваем, что хотят сделать дальше
    }

    //Снова спрашиваем, что хотят сделать дальше
    private void askForNextAction() throws IOException {
        System.out.println("\nЧто вы хотите сделать дальше?");
        System.out.println("1. Отсортировать данные");
        System.out.println("2. Найти элемент");
        System.out.println("3. Записать данные сортировки и поиска в файл");
        System.out.println("4. Вернуться в главное меню");

        //Выбираем дальнейшее действие: сортировка, поиск или назад
        int choice = readIntInput("Выберите действие: ", 1, 4);
        switch (choice) {
            case 1 -> typeSorting();
            case 2 -> performSearch();
            case 3 -> {
                if (!isDefaultSorted) {
                    System.out.println("Сохранение в файл доступно только после сортировки по умолчанию.");
                } else {
                    fileRecordAdd();
                }
            }
            case 4 -> {
            }
        }
    }

    private void typeSorting() throws IOException {
        System.out.println("\nВыберите тип сортировки:");
        System.out.println("1. Сортировка по умолчанию");
        System.out.println("2. Пользовательская сортировка");
        System.out.println("3. Вернуться в главное меню");

        //Выбираем тип сортировки
        int choiceSort = readIntInput("Выберите действие: ", 1, 3);
        switch (choiceSort) {
            case 1 -> performSorting();
            case 2 -> customSorting();
            case 3 -> {
            }
        }
    }

    private void customSorting() throws IOException {
        if (checkEmptyData()) return; //Проверка наличия данных
        customSortCurrentData(); //Выполнение кастомной сортировки
        printCurrentData(); // Вывод отсортированных данных
        askForNextAction(); //Запрос следующих действий
    }


    private void performSorting() throws IOException {
        if (checkEmptyData()) return;
        sortCurrentData();
        printCurrentData();
        askForNextAction();
    }

    private void performSearch() throws IOException {
        if (checkEmptyData()) return;
        searchCurrentData(); //ищет эл и сразу возвращает его
        askForNextAction();
    }

    //Кастомная сортировка текущих данных
    private void customSortCurrentData() {
        switch (currentDataType) { // В зависимости от ранее выбранного типа данных выполняем один из кейсов
            case 1 -> CustomSort.customSort( // Вызываем метод класса кастомной сортировки
                    (CustomArrayList<Bus>) currentData, // Передаём в метод текущий(полученный ранее) список объектов
                    // Передаём в метод компаратор с указанием класса "Bus" и его метода "getNumber" для сравнения
                    // объектов типа "Bus" по значениям поля "Number"
                    Comparator.comparingInt(Bus::getNumber),
                    // Передаём в метод гетер класса "Bus" для извлечения из поля "Number" значения типа "int"
                    Bus::getNumber);
            case 2 -> CustomSort.customSort(
                    (CustomArrayList<Student>) currentData,
                    Comparator.comparingInt(Student::getGroupNumber),
                    Student::getGroupNumber);
            case 3 -> System.out.println("Сортировка невозможна: У класса \"User\" нет числового поля.");
        }
        isSorted = true;
        isDefaultSorted = false;
    }

    //Обычная сортировка текущих данных
    private void sortCurrentData() {
        switch (currentDataType) {
            case 1 -> SelectionSort.selectionSort((CustomArrayList<Bus>) currentData);
            case 2 -> SelectionSort.selectionSort((CustomArrayList<Student>) currentData);
            case 3 -> SelectionSort.selectionSort((CustomArrayList<User>) currentData);
        }
        isSorted = true;
        isDefaultSorted = true;
    }

    //Поиск текущих данных
    private void searchCurrentData() {
        switch (currentDataType) {
            case 1 -> {
                Bus bus = new BusManualInputHandler().input(); //Создаем объект-образец для сравнения.
                searchResult = BinarySearch.binarySearch((CustomArrayList<Bus>) currentData, bus);
                printSearchResult(searchResult, bus);
            }
            case 2 -> {
                Student student = new StudentManualInputHandler().input();
                searchResult = BinarySearch.binarySearch((CustomArrayList<Student>) currentData, student);
                printSearchResult(searchResult, student);
            }
            case 3 -> {
                User user = new UserManualInputHandler().input();
                searchResult = BinarySearch.binarySearch((CustomArrayList<User>) currentData, user);
                printSearchResult(searchResult, user);
            }
        }
    }

    //Метод вывода найденного эл на экран
    private <T> void printSearchResult(int index, T element) {
        if (index >= 0) {
            System.out.println("\nЭлемент найден на позиции: " + index);
            System.out.println("Найденный элемент: " + element);
        } else {
            System.out.println("\nЭлемент не найден в массиве");
        }
    }

    //Если мы нажимаем сразу на 2 или 3 в Главном меню, то выводит сообщение
    private boolean checkEmptyData() {
        if (currentData == null || currentData.isEmpty()) {
            System.out.println("Нет данных для операции. Сначала заполните массив.");
            return true;
        }
        return false;
    }

    //Выводит текущие данные
    private void printCurrentData() {
        System.out.println("\n=== Текущие данные ===");
        currentData.forEach(System.out::println);
    }

    private CustomArrayList<Bus> fillBusData(int method, int size, String filePath) {
        //Создаем Map с тремя стратегиями заполнения
        //ключ (Integer) — номер метода (1, 2, 3)
        //значение (DataFillingStrategy<Bus>) — объект, который выполняет заполнение.
        Map<Integer, DataFillingStrategy<Bus>> strategies = new HashMap<>();
        //каждому ключу приписываем свой метод заполнения (1- вручную, 2 - из файла, 3 - рандом)
        strategies.put(1, new ManualFillingStrategy<>(() -> {
            BusManualInputHandler busManualInputHandler = new BusManualInputHandler();
            return busManualInputHandler.input();
        }));
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new BusFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(new BusGeneratorInputHandler()::input));

        isSorted = false;
        searchResult = -2;

        return strategies.get(method).fillData(size); //Возвращает CustomArrayList<Bus> с заполненными данными
    }

    private CustomArrayList<Student> fillStudentData(int method, int size, String filePath) {
        Map<Integer, DataFillingStrategy<Student>> strategies = new HashMap<>();
        //ManualFillingStrategy<> класс, отвечающий за ручной ввод данных
        //createStudentManually метод ручного ввода
        strategies.put(1, new ManualFillingStrategy<>(() -> {
            StudentManualInputHandler studentManualInputHandler = new StudentManualInputHandler();
            return studentManualInputHandler.input();
        }));
        //FileFillingStrategy<> стратегия заполнения из файла
        //filePath путь к файлу, parts — строка из файла, разбитая на части
        //StudentFileInputHandler(parts).input() — создает Student на основе данных из файла.
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new StudentFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(new StudentGeneratorInputHandler()::input));

        isSorted = false;
        searchResult = -2;

        return strategies.get(method).fillData(size);
    }

    private CustomArrayList<User> fillUserData(int method, int size, String filePath) {
        Map<Integer, DataFillingStrategy<User>> strategies = new HashMap<>();
        strategies.put(1, new ManualFillingStrategy<>(() -> {
            UserManualInputHandler userManualInputHandler = new UserManualInputHandler();
            return userManualInputHandler.input();
        }));
        strategies.put(2, new FileFillingStrategy<>(filePath, parts -> new UserFileInputHandler(parts).input()));
        strategies.put(3, new RandomFillingStrategy<>(new UserGeneratorInputHandler()::input));

        isSorted = false;
        searchResult = -2;

        return strategies.get(method).fillData(size);
    }

    //считывание целого числа от пользователя в заданном диапазоне (min - max).
    //int readIntInput(...) — метод возвращает целое число.
    //String prompt — текстовый подсказка, которую нужно вывести перед вводом
    //int min, int max — минимальное и максимальное допустимые значения
    private int readIntInput(String prompt, int min, int max) {
        //выполняется в цикле если ввод некорректный, метод просит ввести значение заново.
        //цикл выполняется бесконечно, пока не будет введено корректное число
        //Как только ввод пройдет проверку, вызывается return, и метод завершится.
        while (true) {
            try {
                System.out.print(prompt);//выводим текстовое сообщение
                //считываем строку, введенную пользователем и преобразуем строку в число (int).
                int value = Integer.parseInt(scanner.nextLine());
                //Если число входит в указанный диапазон, оно возвращается
                if (value >= min && value <= max) {
                    return value;
                }
                //иначе выводится сообщение об ошибке:
                System.out.println("Ошибка: введите число от " + min + " до " + max);
                //Обрабатываем исключение, если введено не число
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

    private void fileRecordAdd() throws IOException {
        if (isSorted & searchResult != -2) {
            new FileRecordAdd().record(scanner, currentData, searchResult);
        } else System.out.println("Вы еще не выполнили сортировку по умолчанию и поиск элемента.");
    }
}
