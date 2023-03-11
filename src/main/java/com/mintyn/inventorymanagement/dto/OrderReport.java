package com.mintyn.inventorymanagement.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Entity
@AllArgsConstructor
public class OrderReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int totalQuantity;

    private double totalValue;

    public OrderReport(LocalDate date, int totalQuantity, double totalValue) {
        this.date = date;
        this.totalQuantity = totalQuantity;
        this.totalValue = totalValue;
    }
}