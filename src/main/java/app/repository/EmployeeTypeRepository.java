package app.repository;
import app.domain.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
    Optional<EmployeeType> findByEmpTypeId(Integer id);
}
