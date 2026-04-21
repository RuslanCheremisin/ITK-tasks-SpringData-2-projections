package rus.cheremisin.springdata2projections.exception;

public class DepartmentIsNotAddedToDBException extends RuntimeException {
    public DepartmentIsNotAddedToDBException(String message) {
        super(message);
    }
}
