package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import rus.cheremisin.springdata2projections.enums.Position;

public record UpdateEmployeeRequest(@NotNull @Positive Long id,
                                    @NotNull @NotBlank String firstName,
                                    @NotNull @NotBlank String lastName,
                                    @NotNull @Positive Long departmentId,
                                    @NotNull Position position,
                                    @DecimalMin("27093.0") Double salary) {
}
