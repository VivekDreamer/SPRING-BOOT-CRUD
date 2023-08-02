package com.vivek.springbootcrud.service;

import com.vivek.springbootcrud.model.MongoEmployee;

public interface MongoEmpService {
    public MongoEmployee saveOrUpdate(MongoEmployee emp);
}
