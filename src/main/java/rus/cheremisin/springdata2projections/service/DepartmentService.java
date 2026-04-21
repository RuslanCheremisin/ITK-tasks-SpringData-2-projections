package rus.cheremisin.springdata2projections.service;

import org.springframework.data.domain.Pageable;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO dto);

    List<DepartmentDTO> getAllDepartments(Pageable pageable);
}
