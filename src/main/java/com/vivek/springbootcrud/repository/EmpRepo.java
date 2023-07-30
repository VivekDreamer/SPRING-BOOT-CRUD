package com.vivek.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.springbootcrud.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long>{
    
}
