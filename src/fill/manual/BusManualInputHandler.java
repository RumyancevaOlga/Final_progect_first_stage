package fill.manual;

import fill.InputHandler;
import model.Bus;
import validation.BusValidator;
import validation.ValidationException;
import validation.ValidationService;
import validation.Validator;

import java.util.Scanner;

public class BusManualInputHandler implements InputHandler<Bus> {
    // Используем интерфейс Validator с конкретной реализацией BusValidator
    private final Validator<Bus> validator = new BusValidator();

    @Override
    public Bus input() {
        Scanner scanner = new Scanner(System.in);

        // Главный цикл: продолжается до тех пор, пока не будет введён корректный объект Bus
        while (true) {
            try {
                // Ввод и парсинг номера автобуса
                System.out.print("Введите номер автобуса (Целое число от 1 до 999): ");
                int number = Integer.parseInt(scanner.nextLine());

                // Ввод модели автобуса
                System.out.print("Введите модель автобуса: ");
                String model = scanner.nextLine().trim();

                // Ввод и парсинг пробега
                System.out.print("Введите пробег (Положительное число от 1 до 1.000.000): ");
                String mileageInput = scanner.nextLine();
                double mileage = Double.parseDouble(mileageInput);

                // Создание объекта Bus с использованием билдера
                Bus bus = new Bus.Builder()
                        .number(number)
                        .model(model)
                        .mileage(mileage)
                        .build();

                // Валидация введённых данных через универсальный сервис
                ValidationService.validateData(bus, validator);

                return bus;

            } catch (ValidationException e) {
                // Обработка ошибок валидации
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                // Обработка ошибок преобразования строки в число
                System.out.println("Ошибка: ожидалось положительное число. Проверьте ввод.");
            }
        }
    }
}
