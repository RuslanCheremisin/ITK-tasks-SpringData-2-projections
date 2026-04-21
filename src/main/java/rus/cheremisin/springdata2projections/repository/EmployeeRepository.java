package rus.cheremisin.springdata2projections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rus.cheremisin.springdata2projections.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByTitle(String title);
}
