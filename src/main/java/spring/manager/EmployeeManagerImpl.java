package spring.manager;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import spring.model.Employee;
import spring.model.EmployeeRowMapper;

public class EmployeeManagerImpl extends JdbcDaoSupport implements EmployeeManager {

    @Override
    public Employee queryById(Integer id) {
        String sql = "SELECT * FROM employee WHERE empId = ?";
        Employee employee = this.getJdbcTemplate().queryForObject(sql, new EmployeeRowMapper(), id);
        return employee;
    }
}
