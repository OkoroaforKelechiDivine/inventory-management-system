package com.mintyn.inventorymanagement.service.product;

import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(int productId)  {
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product with id " + productId + "not found"));
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        Product existingProduct = productRepository.findById(updatedProduct.getId()).orElseThrow(() -> new RuntimeException("Product with id " + updatedProduct.getId() + "not found"));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        return productRepository.save(existingProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
