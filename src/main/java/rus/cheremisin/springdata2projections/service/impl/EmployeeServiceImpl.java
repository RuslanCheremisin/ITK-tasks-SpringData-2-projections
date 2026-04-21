package rus.cheremisin.springdata2projections.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rus.cheremisin.springdata2projections.DTO.AddEmployeeRequest;
import rus.cheremisin.springdata2projections.DTO.EmployeeDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateEmployeeRequest;
import rus.cheremisin.springdata2projections.entity.Department;
import rus.cheremisin.springdata2projections.entity.Employee;
import rus.cheremisin.springdata2projections.exception.DepartmentNotFoundException;
import rus.cheremisin.springdata2projections.exception.EmployeeNotFoundException;
import rus.cheremisin.springdata2projections.mapper.EmployeeMapper;
import rus.cheremisin.springdata2projections.repository.DepartmentRepository;
import rus.cheremisin.springdata2projections.repository.EmployeeRepository;
import rus.cheremisin.springdata2projections.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    DepartmentRepository departmentRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees(Pageable pageable) {
        if (pageable == null) {
            throw new NullPointerException("pageable is null!");
        }
        return employeeMapper.toDtoList(employeeRepository.findAll(pageable).toList());
    }

    @Override
    public EmployeeDTO addEmployee(AddEmployeeRequest request) {
        if (request == null) {
            throw new NullPointerException("cannot add from null request");
        }
        Optional<Department> departmentOptional = departmentRepository.findById(request.departmentId());

        Employee newEmployee = employeeMapper.fromAddRequestToEmployee(request);
        if (departmentOptional.isEmpty()) {
            throw new DepartmentNotFoundException("no department with id=" + request.departmentId());
        } else {
            newEmployee.setDepartment(departmentOptional.get());
        }
        return employeeMapper.toDto(employeeRepository.save(newEmployee));
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        if (id == null) {
            throw new NullPointerException("check ID param, it cannot be null");
        }
        Optional<Employee> departmentOptional = employeeRepository.findById(id);
        if (departmentOptional.isEmpty()) {
            throw new EmployeeNotFoundException("no employee by that ID is found");
        }
        return employeeMapper.toDto(departmentOptional.get());
    }

    @Override
    public EmployeeDTO updateEmployee(UpdateEmployeeRequest request) {
        if (request != null) {
            Optional<Employee> employeeOptional = employeeRepository.findById(request.departmentId());
            if (employeeOptional.isEmpty()) {
                throw new EmployeeNotFoundException("no employee with such ID is found");
            }
            Employee existingEmployee = employeeOptional.get();

            Optional<Department> department = departmentRepository.findById(request.departmentId());
            if (department.isEmpty()) {
                throw new DepartmentNotFoundException("no department by that ID is found");
            }

            existingEmployee.setFirstName(request.firstName());
            existingEmployee.setLastName(request.lastName());
            existingEmployee.setDepartment(department.get());
            existingEmployee.setPosition(request.position());
            existingEmployee.setSalary(request.salary());

            return employeeMapper.toDto(employeeRepository.save(existingEmployee));
        } else {
            throw new NullPointerException("cannot update employee from null request");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        if (id == null) {
            throw new NullPointerException("check ID param, it cannot be null");
        }
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("no employee with such ID");
        }
        employeeRepository.delete(employeeOptional.get());
    }
}