package com.mintyn.inventorymanagement.controller.product;

import com.mintyn.inventorymanagement.dto.ProductDTO;
import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.repository.product.ProductRepository;
import com.mintyn.inventorymanagement.service.product.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productService;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestParam("id") int id, @RequestParam("price") double price) {
        return ResponseEntity.ok().body(productService.updateProductPrice(id, price));
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
}
