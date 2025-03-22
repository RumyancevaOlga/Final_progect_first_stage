import collection.CustomArrayList;
import display.UserInterface;
import fill.InputHandler;
import model.Bus;
import model.Student;
import model.User;
import sort.SelectionSort;
import validation.*;

public class Main {
    public static void main(String[] args) {
//        // Создаем CustomArrayList для хранения объектов Bus
//        CustomArrayList<Bus> buses = new CustomArrayList<>();
//        // Создаем объекты Bus с разными значениями
//        buses.add(new Bus.Builder().number(208).model("Reno").mileage(32400.1).build());
//        buses.add(new Bus.Builder().number(103).model("Kia").mileage(14001.0).build());
//        buses.add(new Bus.Builder().number(307).model("Volvo").mileage(25400.3).build());
//        buses.add(new Bus.Builder().number(609).model("Exeed").mileage(5010.0).build());
//        buses.add(new Bus.Builder().number(147).model("Mercedes").mileage(306120.0).build());
//        buses.add(new Bus.Builder().number(222).model("Porsche").mileage(15000.5).build());
//        buses.add(new Bus.Builder().number(510).model("Lada").mileage(21060.3).build());
//        buses.add(new Bus.Builder().number(612).model("Lada").mileage(3004.12).build());
//        buses.add(new Bus.Builder().number(208).model("Reno").mileage(32400.1).build());
//        // Выводим список до сортировки
//        System.out.println("Автобусы до сортировки:");
//        System.out.println(buses);
//        // Выполняем сортировку с использованием SelectionSort
//        SelectionSort.selectionSort(buses);
//        // Выводим список после сортировки
//        System.out.println("\nАвтобусы после сортировки:");
//        System.out.println(buses);

        UserInterface userInterface = new UserInterface();

        userInterface.menu();
    }
}
