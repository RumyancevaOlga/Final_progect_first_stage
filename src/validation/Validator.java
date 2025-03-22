package validation;

public interface Validator<T> {
    void validate(T object) throws ValidationException;
}