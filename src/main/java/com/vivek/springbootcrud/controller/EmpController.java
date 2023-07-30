package com.vivek.springbootcrud.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vivek.springbootcrud.model.Employee;
import com.vivek.springbootcrud.service.EmployeeNewService;

@RestController
@RequestMapping("/global")
public class EmpController {

    @Autowired
    private EmployeeNewService empService;

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Employee employeeSaved = empService.addEmployee(employee);
        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> listOfAllEmployee = empService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listOfAllEmployee,HttpStatus.OK);
    }

    @GetMapping("/emp/{empId}")
    public ResponseEntity<?> getEmpById(@PathVariable("empId") Long empId){
        Employee retrieved = empService.getEmpById(empId);
        return new ResponseEntity<Employee>(retrieved,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Void> deleteById(@PathVariable("empId") Long empId){
        empService.deleteById(empId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = empService.addEmployee(employee);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.CREATED);
    }

    @GetMapping("/")
    public String home(){
        return "<h1>welcome</h1>";
    }

    @GetMapping("/user")
    public List<Employee> user(){
        return empService.dummy();
    }

    @GetMapping("/home")
    public String admin(){
        return "<h1>Hii Admin!!!</h1>";
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

}
