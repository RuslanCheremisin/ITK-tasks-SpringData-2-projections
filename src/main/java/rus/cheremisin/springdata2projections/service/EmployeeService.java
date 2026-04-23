package rus.cheremisin.springdata2projections.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Pageable;
import rus.cheremisin.springdata2projections.DTO.AddEmployeeRequest;
import rus.cheremisin.springdata2projections.DTO.EmployeeDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees(Pageable pageable);
    EmployeeDTO addEmployee(@NotNull @Valid AddEmployeeRequest request);
    EmployeeDTO getEmployeeById(@NotNull @Positive Long id);
    EmployeeDTO updateEmployee(@NotNull @Valid UpdateEmployeeRequest request);
    void deleteEmployee(@NotNull @Positive Long id);

    String getEmployeesPositionById(@NotNull @Positive Long id);

    String getEmployeesFullNameById(@NotNull @Positive Long id);

    String getEmployeesDepartmentNameById(@NotNull @Positive Long id);
}
