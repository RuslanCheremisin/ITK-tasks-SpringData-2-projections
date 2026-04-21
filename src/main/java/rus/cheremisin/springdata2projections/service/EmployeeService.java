package rus.cheremisin.springdata2projections.service;

import org.springframework.data.domain.Pageable;
import rus.cheremisin.springdata2projections.DTO.AddEmployeeRequest;
import rus.cheremisin.springdata2projections.DTO.EmployeeDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees(Pageable pageable);
    EmployeeDTO addEmployee(AddEmployeeRequest request);
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(UpdateEmployeeRequest request);
    void deleteEmployee(Long id);

}
