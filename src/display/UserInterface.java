package display;

import collection.CustomArrayList;
import fill.file.BusFileFill;
import fill.file.FileReaderCsv;
import model.Bus;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public void menu() {
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите способ заполнения массива:\n" +
                    "заполнение из файла: 1\n" +
                    "ручной ввод: 2\n" +
                    "заполнение случайными значениями: 3\n" +
                    "выход из программы: 4");

            try {
                int fillMethod = in.nextInt();

                switch (fillMethod) {
                    case 1:
                        FileReaderCsv fileReaderCsv = new FileReaderCsv();
                        fileReaderCsv.readFile("src/resources/Bus.csv", 5);
                        BusFileFill fileFill = new BusFileFill();
                        fileFill.setFileReaderCsv(fileReaderCsv);
                        CustomArrayList<Bus> buses =  fileFill.input();
                        for (Object bus: buses) {
                            System.out.println(bus);
                        }

                        fileReaderCsv.readFile("src/resources/Bus.csv", 15);
                        fileFill.setFileReaderCsv(fileReaderCsv);
                        buses =  fileFill.input();
                        for (Object bus: buses) {
                            System.out.println(bus);
                        }

                        fileReaderCsv.readFile("src/resources/NullBus.csv", 15);
                        fileFill.setFileReaderCsv(fileReaderCsv);
                        buses =  fileFill.input();
                        for (Object bus: buses) {
                            System.out.println(bus);
                        }

                        fileReaderCsv.readFile("src/resources/NotBus.csv", 15);
                        fileFill.setFileReaderCsv(fileReaderCsv);
                        buses =  fileFill.input();
                        for (Object bus: buses) {
                            System.out.println(bus);
                        }
                        break;
                    case 4:
                        System.exit(0);
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("Неверный ввод.");
                menu();
            }

            System.out.println("Введите желаемый размер массива (целое число)");

            try {
                int size = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите целое число");
                menu();
            }


        }
    }
}
