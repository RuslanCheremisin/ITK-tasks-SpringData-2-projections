package rus.cheremisin.springdata2projections.DTO;

import jakarta.validation.constraints.NotNull;

public record DepartmentDTO(@NotNull String name)  {
}
