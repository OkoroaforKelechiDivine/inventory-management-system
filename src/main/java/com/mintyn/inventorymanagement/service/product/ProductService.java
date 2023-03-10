package com.mintyn.inventorymanagement.service.product;

import com.mintyn.inventorymanagement.models.product.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Product updatedProduct);

    List<Product> getAllProducts();
}
