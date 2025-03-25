package validation;

import model.Bus;

public class BusValidator implements Validator<Bus> {
    @Override
    public void validate(Bus bus) throws ValidationException {
        boolean symbol = false;
        for (int i = 0; i < bus.getModel().length(); i++) {
            char c = bus.getModel().charAt(i);
            if (Character.isLetter(c)) {
                symbol =  true;
            }
        }
        if (bus.getNumber() <= 0 || bus.getNumber() > 999) {
            throw new ValidationException("Номер автобуса должен быть положительный числом от 1 до 999.");
        }
        if (bus.getModel() == null || bus.getModel().isBlank()) {
            throw new ValidationException("Модель автобуса не может быть пустой.");
        }
        if (!symbol) {
            throw new ValidationException("Модель автобуса должна содержать хотя бы один символ.");
        }
        if (bus.getMileage() < 0 || bus.getMileage() > 1000000) {
            throw new ValidationException("Пробег не может быть отрицательным и превышать 1.000.000.");
        }
    }
}
