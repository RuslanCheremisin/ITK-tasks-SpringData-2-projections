package rus.cheremisin.springdata2projections.exception;

public class DepartmentNotFoundException extends EntityWasNotFoundException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
