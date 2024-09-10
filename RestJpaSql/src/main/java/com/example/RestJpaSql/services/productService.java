package com.example.RestJpaSql.services;

import com.example.RestJpaSql.entity.product;
import com.example.RestJpaSql.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private productRepo repo;

    public ResponseEntity<product> addProduct(@RequestBody product prod)
    {
        return new ResponseEntity<>(repo.save(prod), HttpStatus.OK);
    }

    public product fetch(@RequestBody long id)
    {
        Optional<product> optional=repo.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    public List<product> fetchall(){
        return repo.findAll();
    }

    public product delete(@RequestBody long id)
    {

        Optional<product> optional=repo.findById(id);
        if(optional.isPresent()) {
            repo.deleteById(id);
            return optional.get();
        }
        return null;
    }

    public product update(@RequestBody long id, @RequestBody product prod)
    {
        Optional<product> optional = repo.findById(id);
        if(optional.isPresent())
        {
            product p=optional.get();
            p.setBrand(prod.getBrand());
            p.setDescription(prod.getDescription());
            p.setQty(prod.getQty());
            p.setPrice(prod.getPrice());
            repo.save(p);

            return p;

        }
        return null;
    }


}
