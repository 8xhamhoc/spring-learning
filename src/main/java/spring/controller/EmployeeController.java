package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.model.Employee;
import spring.request.EmployeeRequest;
import spring.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") String id) {
        int empId = Integer.parseInt(id);
        return employeeService.queryById(empId);
    }


    @PostMapping("/employees")
    public Employee findById(@RequestBody EmployeeRequest request) {
        return employeeService.queryById(request.getId());
    }

}
