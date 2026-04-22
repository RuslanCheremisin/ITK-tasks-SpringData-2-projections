package rus.cheremisin.springdata2projections.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rus.cheremisin.springdata2projections.DTO.AddEmployeeRequest;
import rus.cheremisin.springdata2projections.DTO.EmployeeDTO;
import rus.cheremisin.springdata2projections.entity.Employee;


import java.util.List;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface EmployeeMapper {
    @Mapping(target = "departmentDTO", source = "department")
    EmployeeDTO toDto(Employee employee);
    Employee toEmployee(EmployeeDTO dto);
    List<EmployeeDTO> toDtoList(List<Employee> employees);
    Employee fromAddRequestToEmployee(AddEmployeeRequest request);
}
