package com.example.FeignProductService.resource;

import com.example.FeignProductService.model.Product;
import com.example.FeignProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-service")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products-by-category/{category}")
    public List<Product> findByCategory(@PathVariable("category") String category) {
        return productService.findByCategory(category);
    }

    @GetMapping("/products-by-id/{id}")
    public Product findById(@PathVariable("id") int id) {
        return productService.findById(id);
    }
}
