package spring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import spring.entity.Employee;
import spring.repository.EmployeeRepository;

public class Emp {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

}
