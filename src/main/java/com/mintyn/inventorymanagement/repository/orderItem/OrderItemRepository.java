package com.mintyn.inventorymanagement.repository.orderItem;

import com.mintyn.inventorymanagement.models.orderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
