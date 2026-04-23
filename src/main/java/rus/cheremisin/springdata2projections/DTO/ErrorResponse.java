package rus.cheremisin.springdata2projections.DTO;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        HttpStatus status,
        String errorCode,
        String message,
        LocalDateTime timestamp,
        String path) {
}
