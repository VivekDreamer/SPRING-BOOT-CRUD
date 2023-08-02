package com.vivek.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.springbootcrud.model.MongoEmployee;
import com.vivek.springbootcrud.service.MongoEmpService;

@RestController
public class MongoEmpController {
    @Autowired
    private MongoEmpService service;

    @PostMapping
    public ResponseEntity<MongoEmployee> saveOrUpdate(@RequestBody MongoEmployee emp){
        return new ResponseEntity<MongoEmployee>(service.saveOrUpdate(emp),  HttpStatus.ACCEPTED);
    }
}
