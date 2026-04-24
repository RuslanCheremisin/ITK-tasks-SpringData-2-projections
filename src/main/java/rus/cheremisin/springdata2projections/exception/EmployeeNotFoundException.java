package rus.cheremisin.springdata2projections.exception;

public class EmployeeNotFoundException extends EntityWasNotFoundException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
