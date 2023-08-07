package com.vivek.springbootcrud.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.vivek.springbootcrud.model.MongoEmployee;

public interface MongoEmpService {
    public MongoEmployee saveOrUpdate(MongoEmployee emp);

    public List<MongoEmployee> getAllEmp();

    public MongoEmployee getEmpById(ObjectId id);

    public void deleteById(ObjectId id);

}
