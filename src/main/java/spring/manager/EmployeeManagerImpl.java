package spring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import spring.model.Employee;
import spring.model.EmployeeRowMapper;
import spring.repository.EmployeeRepository;

public class EmployeeManagerImpl extends JdbcDaoSupport implements EmployeeManager {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee queryById(Integer id) {
        String sql = "SELECT * FROM employee WHERE empId = ?";
//        Employee employee = this.getJdbcTemplate().queryForObject(sql, new EmployeeRowMapper(), id);
        spring.entity.Employee employee1 = employeeRepository.findByName("David");
        Employee employee = null;
        if (employee1 != null) {
            employee.setId(employee1.getId());
            employee.setName(employee1.getName());
        }
        return employee;
    }




}
