package com.vivek.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.springbootcrud.customException.BuisnessException;
import com.vivek.springbootcrud.customException.ControllerException;
import com.vivek.springbootcrud.model.Employee;
import com.vivek.springbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try {
            Employee employeeSaved = empService.addEmployee(employee);
            return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
        } catch (BuisnessException e) {
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        } catch(HttpMessageNotReadableException e){
            ControllerException controllerException = new ControllerException("612", "Required request body is missing or invalid");
            return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        } catch(Exception e){
            ControllerException controllerException = new ControllerException("611", "Something went wrong in controller!!");
            return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> listOfAllEmployee = empService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listOfAllEmployee,HttpStatus.OK);
    }

    @GetMapping("/emp/{empId}")
    public ResponseEntity<?> getEmpById(@PathVariable("empId") Long empId){
        try {
            Employee retrieved = empService.getEmpById(empId);
            return new ResponseEntity<Employee>(retrieved,HttpStatus.OK);
        } catch (BuisnessException e) {
            ControllerException controllerException = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        } catch(Exception e){
            ControllerException controllerException = new ControllerException("612", "Something went wrong in controller!!");
            return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        }
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
}
