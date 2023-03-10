package com.mintyn.inventorymanagement.repository.product;

import com.mintyn.inventorymanagement.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
