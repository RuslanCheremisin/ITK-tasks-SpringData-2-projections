package rus.cheremisin.springdata2projections.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;
import rus.cheremisin.springdata2projections.DTO.UpdateDepartmentRequest;
import rus.cheremisin.springdata2projections.entity.Department;
import rus.cheremisin.springdata2projections.exception.DepartmentNotFoundException;
import rus.cheremisin.springdata2projections.mapper.DepartmentMapper;
import rus.cheremisin.springdata2projections.repository.DepartmentRepository;
import rus.cheremisin.springdata2projections.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    @Override
    public DepartmentDTO addDepartment(@NotNull @Valid DepartmentDTO dto) {
        if (dto == null) {
            throw new NullPointerException("cannot add null department");
        }
        Department newDepartment = departmentMapper.toDepartment(dto);
        return departmentMapper.toDto(departmentRepository.save(newDepartment));
    }

    @Override
    public List<DepartmentDTO> getAllDepartments(Pageable pageable) {
        return departmentMapper.toDtoList(departmentRepository.findAll(pageable).toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(@NotNull @Positive Long id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) {
            throw new DepartmentNotFoundException("no department with id=" + id);
        }
        return departmentMapper.toDto(departmentOptional.get());
    }

    @Override
    public DepartmentDTO updateDepartment(@NotNull @Valid UpdateDepartmentRequest request) {
        if (request != null) {
            Optional<Department> departmentOptional = departmentRepository.findById(request.id());
            if (departmentOptional.isEmpty()) {
                throw new DepartmentNotFoundException("no department with such ID is found");
            }
            Department existingDepartment = departmentOptional.get();

            existingDepartment.setName(request.name());

            return departmentMapper.toDto(departmentRepository.save(existingDepartment));
        } else {
            throw new NullPointerException("cannot update department from null request");
        }
    }

    @Override
    public void deleteDepartment(@NotNull @Positive Long id) {
        if (id == null) {
            throw new NullPointerException("check ID param, it cannot be null");
        }
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) {
            throw new DepartmentNotFoundException("no department with such ID");
        }
        departmentRepository.delete(departmentOptional.get());
    }
}
