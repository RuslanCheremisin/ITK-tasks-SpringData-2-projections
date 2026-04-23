package rus.cheremisin.springdata2projections.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import rus.cheremisin.springdata2projections.enums.Position;

@Entity(name = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @Enumerated(EnumType.STRING)
    Position position;

    @DecimalMin("27093.0") //МРОТ 2026 до вычета НДФЛ
    Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

}
