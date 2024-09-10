package com.example.RestJpaSql.resources;

import com.example.RestJpaSql.entity.product;
import com.example.RestJpaSql.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("product/api")
public class mainController {

    //http:localhost:8090/product/api/add
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


}
