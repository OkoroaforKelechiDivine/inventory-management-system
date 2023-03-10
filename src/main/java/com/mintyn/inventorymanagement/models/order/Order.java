package com.mintyn.inventorymanagement.models.order;

import com.mintyn.inventorymanagement.models.orderItem.OrderItem;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    private String customerPhoneNumber;

    @ManyToOne
    private OrderItem orderItems;
}
