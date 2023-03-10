package com.mintyn.inventorymanagement.controller.order;


import com.mintyn.inventorymanagement.models.order.Order;
import com.mintyn.inventorymanagement.models.order.OrderRequest;
import com.mintyn.inventorymanagement.service.order.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderServiceImplementation orderServiceImplementation;

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderServiceImplementation.placeOrder(orderRequest);
    }
}
