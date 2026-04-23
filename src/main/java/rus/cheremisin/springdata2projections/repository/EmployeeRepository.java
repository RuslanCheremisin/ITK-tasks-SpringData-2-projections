package rus.cheremisin.springdata2projections.repository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rus.cheremisin.springdata2projections.entity.Employee;
import rus.cheremisin.springdata2projections.repository.projections.EmployeeProjection;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT CONCAT(first_name, ' ', last_name) AS fullName FROM employees e WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getFullNameById(@NotNull @Positive Long id);

    @Query(value = "SELECT e.position FROM employees e WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getPositionById(@NotNull @Positive Long id);

    @Query(value = "SELECT d.name as departmentName FROM employees e JOIN departments d ON e.department_id = d.id WHERE e.id = :id",
            nativeQuery = true)
    Optional<EmployeeProjection> getDepartmentNameById(@NotNull @Positive Long id);
}
