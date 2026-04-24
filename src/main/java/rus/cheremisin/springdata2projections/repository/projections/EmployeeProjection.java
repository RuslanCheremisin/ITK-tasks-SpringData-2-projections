package rus.cheremisin.springdata2projections.repository.projections;

import rus.cheremisin.springdata2projections.enums.Position;

public interface EmployeeProjection {
    String getFullName();
    Position getPosition();
    String getDepartmentName();

}
