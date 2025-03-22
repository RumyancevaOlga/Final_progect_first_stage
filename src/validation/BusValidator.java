package validation;

import model.Bus;

public class BusValidator implements Validator<Bus> {
    @Override
    public void validate(Bus bus) throws ValidationException {
        if (bus.getNumber() <= 0 || bus.getNumber() > 999) {
            throw new ValidationException("Номер автобуса должен быть положительный числом от 1 до 999.");
        }
        if (bus.getModel() == null || bus.getModel().isBlank()) {
            throw new ValidationException("Модель автобуса не может быть пустой.");
        }
        if (bus.getMileage() < 0) {
            throw new ValidationException("Пробег не может быть отрицательным.");
        }
    }
}
