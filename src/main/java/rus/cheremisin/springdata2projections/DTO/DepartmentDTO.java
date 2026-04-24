package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepartmentDTO(@NotNull @NotBlank String name)  {
}
