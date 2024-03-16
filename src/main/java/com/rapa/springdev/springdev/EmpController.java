package com.rapa.springdev.springdev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {
    List<Employee> employees = new ArrayList<>();
    @GetMapping("employee")
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Saved Successfully";
    }
}
