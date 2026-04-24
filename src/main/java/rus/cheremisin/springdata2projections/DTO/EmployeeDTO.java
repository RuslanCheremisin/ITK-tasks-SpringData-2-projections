package rus.cheremisin.springdata2projections.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import rus.cheremisin.springdata2projections.enums.Position;

public record EmployeeDTO(
        @NotNull
        @NotBlank
        String firstName,
        @NotNull
        @NotBlank
        String lastName,
        DepartmentDTO departmentDTO,
        Position position,
        Double salary) {
}
