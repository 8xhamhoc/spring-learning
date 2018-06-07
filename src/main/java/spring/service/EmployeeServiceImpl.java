package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.manager.EmployeeManager;
import spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeManager employeeManager;

    @Override
    public Employee queryById(Integer id) {
        return employeeManager.queryById(id);
    }
}
