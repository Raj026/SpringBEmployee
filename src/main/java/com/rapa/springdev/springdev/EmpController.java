package com.rapa.springdev.springdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {
    //DI Controller class depends on service class using Autowired is optional here
    @Autowired
    EmployeeService employeeService;
    List<Employee> employees = new ArrayList<>();
    @GetMapping("employee")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }
    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee employee) {
//        employees.add(employee);
        return employeeService.createEmployee(employee);

    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean ab = employeeService.deleteEmployee(id);
        if(ab) {
            return "Deleted"+id+"Successfully";
        }
        return "NO id Found";
    }

    @PutMapping("employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
