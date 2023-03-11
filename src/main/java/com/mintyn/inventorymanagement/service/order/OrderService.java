package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import com.mintyn.inventorymanagement.models.order.OrderRequest;

import java.util.List;

public interface OrderService {

    OrderItem createOrder(OrderRequest orderRequest) throws Exception;

    List<OrderItem> getAllOrders();

    OrderItem getOrderById(int id);
}
