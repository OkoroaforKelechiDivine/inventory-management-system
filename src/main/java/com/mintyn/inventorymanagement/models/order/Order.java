package com.mintyn.inventorymanagement.models.order;

import com.mintyn.inventorymanagement.models.product.Product;
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
    private Long id;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerPhoneNumber;

    @ManyToOne(optional = false)
    private Product product;
}
