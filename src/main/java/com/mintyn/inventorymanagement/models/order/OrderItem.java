package com.mintyn.inventorymanagement.models.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;

    private int quantity;

    private LocalDate orderDate;

    private String customerName;

    private String productName;

    private double totalPrice;

    private int customerId;

    private String customerPhoneNumber;
}
