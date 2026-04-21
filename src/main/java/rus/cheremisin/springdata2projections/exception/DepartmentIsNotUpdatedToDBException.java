package rus.cheremisin.springdata2projections.exception;

public class DepartmentIsNotUpdatedToDBException extends RuntimeException {
    public DepartmentIsNotUpdatedToDBException(String message) {
        super(message);
    }
}
