package rus.cheremisin.springdata2projections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rus.cheremisin.springdata2projections.entity.Employee;
import rus.cheremisin.springdata2projections.enums.Position;
import rus.cheremisin.springdata2projections.repository.projections.EmployeeProjection;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT CONCAT(first_name, ' ', last_name) AS fullName FROM employees e WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getFullNameById(Long id);

    @Query(value = "SELECT e.position FROM employees e WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getPositionById(Long id);

    @Query(value = "SELECT d.name as departmentName FROM employees e JOIN departments d ON e.department_id = d.id WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getDepartmentNameById(Long id);
}
