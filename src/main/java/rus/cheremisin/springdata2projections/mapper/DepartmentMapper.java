package rus.cheremisin.springdata2projections.mapper;

import org.mapstruct.Mapper;
import rus.cheremisin.springdata2projections.DTO.DepartmentDTO;
import rus.cheremisin.springdata2projections.entity.Department;


import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDto(Department department);
    Department toDepartment(DepartmentDTO dto);

    List<DepartmentDTO> toDtoList(List<Department> list);
}
