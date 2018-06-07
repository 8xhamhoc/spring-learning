package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Employee;
import spring.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable("id") String id) {
        int empId = Integer.parseInt(id);
        return employeeService.queryById(empId);
    }

}
