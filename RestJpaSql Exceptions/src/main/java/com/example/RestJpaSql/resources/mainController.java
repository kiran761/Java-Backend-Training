package com.example.RestJpaSql.resources;

import com.example.RestJpaSql.entity.product;
import com.example.RestJpaSql.exceptions.InvalidValueException;
import com.example.RestJpaSql.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/api")
public class mainController {

    @Autowired
    productService service;

    @PostMapping("/add")
    public ResponseEntity<product> createProduct(@RequestBody product prodReq)
    {

        return service.addProduct(prodReq);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<product> fetch(@PathVariable long id)
    {
        return new ResponseEntity<>(service.fetch(id), HttpStatus.OK);
    }

    @GetMapping("/fetchall")
    public ResponseEntity<List<product>> fetchall()
    {

        return new ResponseEntity<>(service.fetchall(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<product> delete(@PathVariable long id)
    {
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<product> update(@PathVariable long id,@RequestBody product prod)
    {
        return new ResponseEntity<>(service.update(id,prod),HttpStatus.OK);
    }

    @GetMapping("/test")
    public String message(String str) throws InvalidValueException,Exception
    {
        str="Abc";
        if(str==null)
            throw  new NullPointerException("value not provided");
        boolean isNumeric=str.chars().anyMatch(x -> Character.isDigit(x));
        if (isNumeric)
            throw new InvalidValueException("Expected String found int value");
        if(str.length()<8)
            throw new Exception("Length is less than 8");
        else
            return "hello";
    }



}
