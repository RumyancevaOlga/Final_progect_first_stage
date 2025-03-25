package fill.file;

import fill.InputHandler;
import model.Bus;
import validation.BusValidator;
import validation.ValidationException;
import validation.ValidationService;
import validation.Validator;

public class BusFileInputHandler implements InputHandler<Bus> {

    private final Validator<Bus> validator = new BusValidator();
    private String[] line;

    public BusFileInputHandler (String[] line) {this.line = line;}

    @Override
    public Bus input() {

        try {
            Bus bus = new Bus.Builder()
                        .number(Integer.parseInt(line[0]))
                        .model(line[1])
                        .mileage(Double.parseDouble(line[2]))
                        .build();
            ValidationService.validateData(bus, validator);
            return bus;
        } catch (ValidationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
