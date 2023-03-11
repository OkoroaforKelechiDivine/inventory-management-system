package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.exception.OutOfStockException;
import com.mintyn.inventorymanagement.models.order.OrderItem;
import com.mintyn.inventorymanagement.models.order.OrderRequest;
import com.mintyn.inventorymanagement.models.product.Product;
import com.mintyn.inventorymanagement.repository.order.OrderRepository;
import com.mintyn.inventorymanagement.repository.product.ProductRepository;
import com.mintyn.inventorymanagement.service.product.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    KafkaTemplate<String, OrderItem> kafkaTemplate;

    @Autowired
    private OrderProducer orderProducer;

    @Autowired
    private ProductServiceImplementation productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItem createOrder(OrderRequest orderRequest) throws Exception {
            Product product = productService.getProductById(orderRequest.getProductId());
            if (product == null) {
                throw new NullPointerException("Product quantity is not found.");
            }
            if (product.getStock() < orderRequest.getQuantity()){
                throw new OutOfStockException(("Product with id " + product.getId() + " is outta Stock."));
            }
            product.setStock(product.getStock() - orderRequest.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            double totalPrice = orderItem.getQuantity() * product.getOriginalPrice();
            orderItem.setCustomerId(orderRequest.getCustomerId());
            orderItem.setQuantity(orderRequest.getQuantity());
            orderItem.setTotalPrice(totalPrice);
            orderItem.setCustomerName(orderRequest.getCustomerName());
            orderItem.setCustomerPhoneNumber(orderRequest.getCustomerPhoneNumber());

            // Publish order to Kafka for reporting
            orderProducer.send(orderItem);
            return orderRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderItem getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find order with id " + id));
    }
}
