package com.example.FeignClient.resources;

import com.example.FeignClient.interfaces.FeignInterface;
import com.example.FeignClient.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignClient {

    @Autowired
    private FeignInterface feignClient;

    @CircuitBreaker(name ="client-cb", fallbackMethod = "generateResponse" )
    // http://localhost:7082/client/allProducts
    @GetMapping("/client/allProducts")
    public List<Product> getAll() {
        return feignClient.getProducts();
    }

    // http://localhost:7082/client/products-by-id/{id}
    @GetMapping("/client/products-by-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {
//        System.out.println(id);
        return feignClient.getProductsById(id);
    }

    // http://localhost:7082/client/products-by-category/{category}
    @GetMapping("/client/products-by-category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return feignClient.getProductsByCategory(category);
    }

    public String generateResponse(Throwable throwable)
    {
        return "The server is unavailable temporarily";
    }
}
