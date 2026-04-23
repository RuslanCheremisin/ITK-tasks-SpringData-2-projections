package rus.cheremisin.springdata2projections.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Pageable;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO dto);

    List<DepartmentDTO> getAllDepartments(Pageable pageable);

    DepartmentDTO getDepartmentById(@NotNull @Positive Long id);

    DepartmentDTO updateDepartment(@NotNull @Valid UpdateDepartmentRequest request);

    void deleteDepartment(@NotNull @Positive Long id);
}
