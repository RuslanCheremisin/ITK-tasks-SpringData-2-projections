package rus.cheremisin.springdata2projections.exception;

import jakarta.persistence.EntityNotFoundException;

/**
    Создал родительский класс для обобщения 'NotFound' исключений для работы GlobalExceptionHandler
    Добавил в нейминге 'Was' чтобы не путать с jakarta.persistence.EntityNotFoundException
 */
public class EntityWasNotFoundException extends RuntimeException {
    public EntityWasNotFoundException(String message) {
        super(message);

    }
}
