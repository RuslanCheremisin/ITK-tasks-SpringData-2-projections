package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateDepartmentRequest(@NotNull @NotNull @Positive Long id, @NotNull String name) {
}
