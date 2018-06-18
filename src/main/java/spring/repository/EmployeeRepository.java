package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

}
