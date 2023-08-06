package com.vivek.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.springbootcrud.model.MongoEmployee;
import com.vivek.springbootcrud.service.MongoEmpService;

@RestController
@RequestMapping("/mongo")
public class MongoEmpController {
    @Autowired
    private MongoEmpService service;

    @PostMapping("/save")
    public ResponseEntity<MongoEmployee> saveOrUpdate(@RequestBody MongoEmployee emp){
        return new ResponseEntity<MongoEmployee>(service.saveOrUpdate(emp),  HttpStatus.ACCEPTED);
    }

    @GetMapping("/all_emp")
    public ResponseEntity<List<MongoEmployee>> getAllEmployees(){
        List<MongoEmployee> allEmp = service.getAllEmp();
        return new ResponseEntity<List<MongoEmployee>>(allEmp,HttpStatus.OK);
    }
}
