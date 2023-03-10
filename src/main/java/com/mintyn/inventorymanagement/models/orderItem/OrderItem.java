package com.mintyn.inventorymanagement.models.orderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    private int id;

    private String product;

    private int quantity;

    private BigDecimal price;
}
