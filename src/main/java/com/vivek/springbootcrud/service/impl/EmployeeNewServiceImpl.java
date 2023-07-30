package com.vivek.springbootcrud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.springbootcrud.customException.EmptyInputException;
import com.vivek.springbootcrud.model.Employee;
import com.vivek.springbootcrud.repository.EmpRepo;
import com.vivek.springbootcrud.service.EmployeeNewService;

@Service
public class EmployeeNewServiceImpl implements EmployeeNewService{

    @Autowired
    private EmpRepo empRepo;

    private List<Employee> dummyList = new ArrayList<>();
    
    public EmployeeNewServiceImpl() {
        dummyList.add(new Employee(111L, "xyz"));
        dummyList.add(new Employee(112L, "abc"));
        dummyList.add(new Employee(113L, "pqr"));
        dummyList.add(new Employee(114L, "mno"));
        dummyList.add(new Employee(115L, "jkl"));
        dummyList.add(new Employee(116L, "qrs"));
    }
    
    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getName().isEmpty() || employee.getName().length() == 0)
            throw new EmptyInputException("404", "name field is empty! It should contain something.");
        Employee save = empRepo.save(employee);
        return save;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> empList = empRepo.findAll();
        return empList;
    }

    @Override
    public Employee getEmpById(Long empId) {
        Employee employee = empRepo.findById(empId).get();
        return employee;
    }

    @Override
    public void deleteById(Long empId) {
        empRepo.deleteById(empId);
    }

    @Override
    public List<Employee> dummy(){
        return dummyList;
    }
}
