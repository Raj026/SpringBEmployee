package com.rapa.springdev.springdev;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService{
//    Injecting the repository
    @Autowired
    private EmployeeRepository employeeRepository;
//    List<Employee> employees = new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
//        employees.add(null);
//        employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity employeeEntity: employeesList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
//        System.out.println(employees);
//        employees.remove(id);
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity newEmployee = employeeRepository.findById(id).get();
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setName(employee.getName());
        employeeRepository.save(newEmployee);
        return "Update Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp,employee);
        return employee;
    }
}
