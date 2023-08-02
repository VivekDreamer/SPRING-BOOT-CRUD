package com.vivek.springbootcrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.springbootcrud.model.MongoEmployee;
import com.vivek.springbootcrud.repository.MongoEmpRepo;
import com.vivek.springbootcrud.service.MongoEmpService;

@Service
public class MongoEmpServiceImpl implements MongoEmpService {

    @Autowired
    private MongoEmpRepo repo;
    @Override
    public MongoEmployee saveOrUpdate(MongoEmployee emp) {
        return repo.save(emp);
    }
}