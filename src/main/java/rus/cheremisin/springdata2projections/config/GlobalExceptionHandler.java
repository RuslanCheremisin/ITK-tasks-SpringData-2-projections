package rus.cheremisin.springdata2projections.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rus.cheremisin.springdata2projections.DTO.ErrorResponse;
import rus.cheremisin.springdata2projections.exception.DepartmentNotFoundException;
import rus.cheremisin.springdata2projections.exception.EmployeeNotFoundException;
import rus.cheremisin.springdata2projections.exception.EntityWasNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundException.class, DepartmentNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(EntityWasNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseFactory.getNotFoundResponse(e, request));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponseFactory.getInternalServerErrorResponse(e, request));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseFactory.getBadRequestResponse(e, request));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseFactory.getBadRequestResponse(e, request));
    }


    /**
     * Внутренняя фабрика для создания объектов {@link ErrorResponse},
     * используемых в глобальном обработчике исключений.
     *
     * <p>Инкапсулирует логику формирования стандартного тела ответа об ошибке,
     * обеспечивая единообразие структуры для различных типов исключений.</p>
     *
     * <p>Каждый метод фабрики создает {@link ErrorResponse}, заполняя:
     * <ul>
     *     <li>HTTP-статус ошибки</li>
     *     <li>строковый код ошибки (например, "404", "400", "500")</li>
     *     <li>сообщение исключения</li>
     *     <li>временную метку возникновения ошибки</li>
     *     <li>путь запроса, полученный из {@link HttpServletRequest}</li>
     * </ul>
     * </p>
     *
     * <p>Предназначена для использования только внутри {@link GlobalExceptionHandler}
     * и не должна использоваться напрямую в других компонентах приложения.</p>
     */
    private static class ErrorResponseFactory {

        /**
         * Создает {@link ErrorResponse} для ошибок типа "ресурс не найден" (HTTP 404).
         *
         * @param e       исключение, содержащее описание ошибки
         * @param request текущий HTTP-запрос
         * @return объект {@link ErrorResponse} с кодом 404
         */
        private static ErrorResponse getNotFoundResponse(Exception e, HttpServletRequest request) {
            return new ErrorResponse(
                    HttpStatus.NOT_FOUND,
                    "404",
                    e.getMessage(),
                    LocalDateTime.now(),
                    getRequestInfo(request));
        }

        /**
         * Создает {@link ErrorResponse} для ошибок типа "некорректный запрос" (HTTP 400).
         *
         * @param e       исключение, содержащее описание ошибки
         * @param request текущий HTTP-запрос
         * @return объект {@link ErrorResponse} с кодом 400
         */
        private static ErrorResponse getBadRequestResponse(Exception e, HttpServletRequest request) {
            return new ErrorResponse(
                    HttpStatus.BAD_REQUEST,
                    "400",
                    e.getMessage(),
                    LocalDateTime.now(),
                    getRequestInfo(request));
        }

        /**
         * Создает {@link ErrorResponse} для внутренних ошибок сервера (HTTP 500).
         *
         * @param e       исключение, вызвавшее ошибку
         * @param request текущий HTTP-запрос
         * @return объект {@link ErrorResponse} с кодом 500
         */
        private static ErrorResponse getInternalServerErrorResponse(Exception e, HttpServletRequest request) {
            return new ErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "500",
                    e.getMessage(),
                    LocalDateTime.now(),
                    getRequestInfo(request));
        }

        /**
         * Формирует строковое представление информации о текущем HTTP-запросе.
         *
         * <p>Включает в себя HTTP-метод (например, GET, POST) и URI запроса.
         * Используется для логирования или добавления контекста в ответы об ошибках.</p>
         *
         * <p>Пример результата:
         * <pre>
         * Method: GET; Request URI: /employees/42
         * </pre>
         * </p>
         *
         * @param request текущий {@link HttpServletRequest}, из которого извлекаются данные запроса
         * @return строка с методом и URI запроса
         */

        private static String getRequestInfo(HttpServletRequest request) {
            return new StringBuilder("Method: ")
                    .append(request.getMethod())
                    .append("; Request URI: ")
                    .append(request.getRequestURI())
                    .toString();
        }
    }
}