package rus.cheremisin.springdata2projections.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rus.cheremisin.springdata2projections.DTO.AddEmployeeRequest;
import rus.cheremisin.springdata2projections.DTO.EmployeeDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateEmployeeRequest;
import rus.cheremisin.springdata2projections.service.EmployeeService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        List<EmployeeDTO> employees = employeeService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") @Min(1) Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/{id}/full_name")
    public ResponseEntity<String> getEmployeesFullNameById(@PathVariable("id") @Min(1) Long id) {
        String fullName = employeeService.getEmployeesFullNameById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fullName);
    }

    @GetMapping("/{id}/position")
    public ResponseEntity<String> getEmployeesPositionById(@PathVariable("id") @Min(1) Long id) {
        String position = employeeService.getEmployeesPositionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(position);
    }

    @GetMapping("/{id}/department_name")
    public ResponseEntity<String> getEmployeesDepartmentNameById(@PathVariable("id") @Min(1) Long id) {
        String departmentName = employeeService.getEmployeesDepartmemtNameById(id);
        return ResponseEntity.status(HttpStatus.OK).body(departmentName);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody AddEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.addEmployee(request));
    }

    @PutMapping()
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.updateEmployee(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") @Min(1) Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


}