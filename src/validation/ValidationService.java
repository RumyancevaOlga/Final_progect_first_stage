package validation;

public class ValidationService {
    public static <T> void validateData(T entity, Validator<T> validator) throws ValidationException {
        validator.validate(entity);
    }
}
