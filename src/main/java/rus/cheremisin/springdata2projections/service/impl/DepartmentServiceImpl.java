package rus.cheremisin.springdata2projections.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;
import rus.cheremisin.springdata2projections.entity.Department;
import rus.cheremisin.springdata2projections.exception.DepartmentNotFoundException;
import rus.cheremisin.springdata2projections.mapper.DepartmentMapper;
import rus.cheremisin.springdata2projections.repository.DepartmentRepository;
import rus.cheremisin.springdata2projections.service.DepartmentService;


import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository Repository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository Repository, DepartmentMapper departmentMapper) {
        this.Repository = Repository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO dto) {
        if (dto == null) {
            throw new NullPointerException("cannot add null department");
        }
        Department newDepartment = departmentMapper.toDepartment(dto);
        return departmentMapper.toDto(Repository.save(newDepartment));
    }

    @Override
    public List<DepartmentDTO> getAllDepartments(Pageable pageable) {
        if (pageable == null) {
            throw new NullPointerException("pageable is null!");
        }
        return departmentMapper.toDtoList(Repository.findAll(pageable).toList());
    }
}
