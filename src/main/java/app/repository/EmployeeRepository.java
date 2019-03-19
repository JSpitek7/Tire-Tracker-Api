package app.repository;
import app.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    @Query("SELECT   FROM Employee e")
//    Iterable<Employee> findAllEmployees();

}
