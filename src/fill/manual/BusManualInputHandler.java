package fill.manual;

import fill.InputHandler;
import model.Bus;
import validation.BusValidator;
import validation.ValidationException;
import validation.ValidationService;
import validation.Validator;

import java.util.Scanner;

public class BusManualInputHandler implements InputHandler<Bus> {
    private final Validator<Bus> validator = new BusValidator();

    @Override
    public Bus input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите номер автобуса (Целое число от 1 до 999): ");
                int number = Integer.parseInt(scanner.nextLine());

                System.out.print("Введите модель автобуса: ");
                String model = scanner.nextLine();

                System.out.print("Введите пробег (Положительное число): ");
                double mileage = Double.parseDouble(scanner.nextLine());

                Bus bus = new Bus.Builder().number(number).model(model).mileage(mileage).build();
                ValidationService.validateData(bus, validator);

                return bus;
            } catch (ValidationException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
