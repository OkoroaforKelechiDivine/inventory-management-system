package com.mintyn.inventorymanagement.service.product;

import com.mintyn.inventorymanagement.dto.ProductDTO;
import com.mintyn.inventorymanagement.models.product.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO product);

    Product updateProductPrice(int id, double price);

    List<Product> getAllProducts();
}
