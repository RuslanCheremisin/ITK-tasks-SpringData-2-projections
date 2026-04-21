package rus.cheremisin.springdata2projections.exception;

public class EmployeeIsNotAddedToDBException extends RuntimeException {
    public EmployeeIsNotAddedToDBException(String message) {
        super(message);
    }
}
