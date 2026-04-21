package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import rus.cheremisin.springdata2projections.enums.Position;

public record AddEmployeeRequest(@NotNull String firstName,
                                 @NotNull String lastName,
                                 Long departmentId,
                                 Position position,
                                 @Min(27093) Double salary) {
}
