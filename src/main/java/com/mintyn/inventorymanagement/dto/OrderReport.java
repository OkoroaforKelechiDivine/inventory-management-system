package com.mintyn.inventorymanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Getter
@Setter
@AllArgsConstructor
public class OrderReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    private int totalOrder;

    private double totalOrderAmount;

    public OrderReport(LocalDate date, int totalOrder, double totalOrderAmount) {
        this.date = date;
        this.totalOrder = totalOrder;
        this.totalOrderAmount = totalOrderAmount;
    }
}