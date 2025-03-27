package validation;

import model.Bus;

public class BusValidator implements Validator<Bus> {
    @Override
    public void validate(Bus bus) throws ValidationException {
        // Проверка: модель должна содержать хотя бы одну букву
        boolean hasSymbol = false;
        for (int i = 0; i < bus.getModel().length(); i++) {
            char c = bus.getModel().charAt(i);
            if (Character.isLetter(c)) {
                hasSymbol = true;
                break;
            }
        }
        if (!hasSymbol) {
            throw new ValidationException("Модель автобуса должна содержать хотя бы один символ.");
        }

        // Проверка: номер автобуса должен быть от 1 до 999
        if (bus.getNumber() <= 0 || bus.getNumber() > 999) {
            throw new ValidationException("Номер автобуса должен быть положительный числом от 1 до 999.");
        }

        // Проверка: модель не должна быть null или пустой
        if (bus.getModel() == null || bus.getModel().isBlank()) {
            throw new ValidationException("Модель автобуса не может быть пустой.");
        }

        // Проверка: пробег должен быть в пределах от 0 до 1 000 000
        if (bus.getMileage() < 0 || bus.getMileage() > 1000000) {
            throw new ValidationException("Пробег не может быть отрицательным и превышать 1.000.000.");
        }
    }
}
