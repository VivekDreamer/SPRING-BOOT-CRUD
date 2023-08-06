package com.vivek.springbootcrud.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vivek.springbootcrud.model.MongoEmployee;
@Repository
public interface MongoEmpRepo extends MongoRepository<MongoEmployee,ObjectId>{
    
}
