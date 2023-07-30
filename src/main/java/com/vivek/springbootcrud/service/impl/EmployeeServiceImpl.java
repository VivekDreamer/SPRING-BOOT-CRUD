package com.vivek.springbootcrud.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.springbootcrud.customException.BuisnessException;
import com.vivek.springbootcrud.model.Employee;
import com.vivek.springbootcrud.repository.EmpRepo;
import com.vivek.springbootcrud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        //if employee name is empty or it's length is 0.
        //So, as we are in buisness layer then, we should throw buisness exception(custom exceeption)..
        if(employee.getName().isEmpty() || employee.getName().length() == 0){
            throw new BuisnessException("601", "please, send proper name, it's blank.");
        }
        try {
            Employee save = empRepo.save(employee);
            return save;
        } catch (IllegalArgumentException e) {
            //if given whole entity is empty or null then, throw buisness exception according to that!!!
            throw new BuisnessException("602", "given employee is null "+e.getMessage());
        } catch(Exception e){
            //if some other exception came then, throw buisness exception saying "something went wrong in service layer!!!"
            throw new BuisnessException("603", "Something went wrong in service layer, while saving the employee! "+e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> dataList = null;
        try {
            dataList = empRepo.findAll();
        } catch (Exception e) {
             throw new BuisnessException("605", "Something went wrong in service layer while fetching all employees! "+e.getMessage());
        }
        if(dataList.isEmpty())
            throw new BuisnessException("604", "Hey, list is completely empty..nothing can be returned..");
        return dataList;
        
    }

    @Override
    public Employee getEmpById(Long empId) {
        try {
            return empRepo.findById(empId).get(); 
        } catch (IllegalArgumentException e) {
            throw new BuisnessException("606",  "given emp id is null, please send some id to be searched! "+e.getMessage());
        } catch(NoSuchElementException e){
            throw new BuisnessException("607", "given employee id doesn't exist in the db! "+e.getMessage());
        } catch(Exception e){
            throw new BuisnessException("608",  "Something went wrong in service layer while fetching all employees!" +e.getMessage());
        }
    }

    @Override
    public void deleteById(Long empId) {
        empRepo.deleteById(empId);
    }
    
}
