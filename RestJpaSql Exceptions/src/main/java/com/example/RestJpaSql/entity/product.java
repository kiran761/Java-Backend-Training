package com.example.RestJpaSql.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class product {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO )
    private long productId;
    private String description;
    private double price;
}
