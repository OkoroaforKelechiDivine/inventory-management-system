package com.mintyn.inventorymanagement.models.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Order {

    @Id
    private int id;

    private String customerName;

    private String customerPhoneNumber;

    private String orderItems;
}
