package com.mintyn.inventorymanagement.controller.product;

import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.service.product.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productServiceImpl;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productServiceImpl.createProduct(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return productServiceImpl.updateProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }
}
