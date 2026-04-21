package rus.cheremisin.springdata2projections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rus.cheremisin.springdata2projections.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
