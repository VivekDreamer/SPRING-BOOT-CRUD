package com.vivek.springbootcrud.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Document(collection = "MongoEmployee")
public class MongoEmployee {
    @Id
    private ObjectId id;
    private String name;
    private String address;
}
