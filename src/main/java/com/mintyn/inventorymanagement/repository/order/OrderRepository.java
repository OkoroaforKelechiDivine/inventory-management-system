package com.mintyn.inventorymanagement.repository.order;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findAllByProductIdAndTotalPriceIsNull(int id);
}
