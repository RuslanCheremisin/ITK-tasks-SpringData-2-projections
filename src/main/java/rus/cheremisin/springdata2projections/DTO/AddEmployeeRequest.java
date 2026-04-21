package rus.cheremisin.springdata2projections.DTO;

import rus.cheremisin.springdata2projections.enums.Position;

public record AddEmployeeRequest(String firstName,
                                 String lastName,
                                 Long departmentId,
                                 Position position,
                                 Double salary) {
}
