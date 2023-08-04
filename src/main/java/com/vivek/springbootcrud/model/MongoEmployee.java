package com.vivek.springbootcrud.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Document(collection = "MongoEmployee")
public class MongoEmployee {
    @Id
    private int id;
    private String name;
    private String address;
}
