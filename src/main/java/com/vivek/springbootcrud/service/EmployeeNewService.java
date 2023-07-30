package com.vivek.springbootcrud.service;

import java.util.List;

import com.vivek.springbootcrud.model.Employee;

public interface EmployeeNewService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmpById(Long empId);

    void deleteById(Long empId);

    public List<Employee> dummy();
}
