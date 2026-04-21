package rus.cheremisin.springdata2projections.service;

import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Pageable;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO dto);

    List<DepartmentDTO> getAllDepartments(Pageable pageable);

    DepartmentDTO getDepartmentById(@Min(1) Long id);

    DepartmentDTO updateDepartment(UpdateDepartmentRequest request);

    void deleteDepartment(@Min(1) Long id);
}
