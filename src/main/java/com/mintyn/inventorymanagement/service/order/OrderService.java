package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.models.order.Order;
import com.mintyn.inventorymanagement.models.order.OrderRequest;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);
}
