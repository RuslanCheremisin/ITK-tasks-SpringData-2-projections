package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import rus.cheremisin.springdata2projections.enums.Position;

public record AddEmployeeRequest(@NotNull String firstName,
                                 @NotNull String lastName,
                                 Long departmentId,
                                 Position position,
                                 @DecimalMin("27093.0") Double salary) {
}
