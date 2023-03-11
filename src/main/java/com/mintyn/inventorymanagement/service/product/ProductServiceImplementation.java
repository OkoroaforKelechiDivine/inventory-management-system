package com.mintyn.inventorymanagement.service.product;

import com.mintyn.inventorymanagement.dto.ProductDTO;
import com.mintyn.inventorymanagement.models.order.OrderItem;
import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.repository.order.OrderRepository;
import com.mintyn.inventorymanagement.repository.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStockAvailability());
        product.setDescription(productDto.getDescription());
        return productRepository.save(product);
    }

    public Product getProductById(int productId)  {
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product with id " + productId + "not found"));
    }

    @Override
    public Product updateProductPrice(int id, double price) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found."));
        product.setOriginalPrice(product.getPrice());
        product.setPrice(price);
        productRepository.save(product);

        // Update price of new orderItems
        List<OrderItem> newOrderItems = orderRepository.findAllByProductIdAndTotalPriceIsNull(id);
        for (OrderItem orderItem : newOrderItems) {
            double newTotalPrice = orderItem.getQuantity() * price;
            orderItem.setTotalPrice(newTotalPrice);
            orderRepository.save(orderItem);
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
