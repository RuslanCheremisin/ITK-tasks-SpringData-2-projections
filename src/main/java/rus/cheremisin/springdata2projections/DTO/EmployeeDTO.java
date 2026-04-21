package rus.cheremisin.springdata2projections.DTO;


import rus.cheremisin.springdata2projections.enums.Position;

public record EmployeeDTO(
        String firstName,
        String lastName,
        DepartmentDTO departmentDTO,
        Position position,
        Double salary) {
}
