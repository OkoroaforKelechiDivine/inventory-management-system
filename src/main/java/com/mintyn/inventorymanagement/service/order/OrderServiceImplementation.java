package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.models.order.Order;
import com.mintyn.inventorymanagement.models.order.OrderRequest;
import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.repository.order.OrderRepository;
import com.mintyn.inventorymanagement.repository.product.ProductRepository;
import com.mintyn.inventorymanagement.service.product.ProductService;
import com.mintyn.inventorymanagement.service.product.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        Product product = productRepository.findById(orderRequest.getProductId()).orElseThrow(() -> new RuntimeException("Product with id " + orderRequest.getProductId() + " not found"));
        if (product.getStock() == 0) {
            throw new RuntimeException("Product out of stock.");
        }
        product.setStock(product.getStock() - 1);
        productRepository.save(product);

        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setCustomerName(orderRequest.getCustomerName());;
        order.setCustomerPhoneNumber(orderRequest.getCustomerPhoneNumber());
        order.setProduct(product);
        orderRepository.save(order);

        kafkaTemplate.send("orders", order);
        return order;
}
}
