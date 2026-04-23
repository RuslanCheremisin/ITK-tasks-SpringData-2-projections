package rus.cheremisin.springdata2projections.DTO;


import jakarta.validation.constraints.NotNull;
import rus.cheremisin.springdata2projections.enums.Position;

public record EmployeeDTO(
        @NotNull String firstName,
        @NotNull String lastName,
        DepartmentDTO departmentDTO,
        Position position,
        Double salary) {
}
