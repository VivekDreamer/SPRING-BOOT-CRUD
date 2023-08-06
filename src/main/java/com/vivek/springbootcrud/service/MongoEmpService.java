package com.vivek.springbootcrud.service;

import java.util.List;

import com.vivek.springbootcrud.model.MongoEmployee;

public interface MongoEmpService {
    public MongoEmployee saveOrUpdate(MongoEmployee emp);

    public List<MongoEmployee> getAllEmp();
}
