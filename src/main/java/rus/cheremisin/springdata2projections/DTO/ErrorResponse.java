package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        @NotNull
        HttpStatus status,
        @NotNull
        @NotBlank String errorCode,
        @NotNull
        @NotBlank String message,
        @NotNull LocalDateTime timestamp,
        @NotNull String path) {
}
