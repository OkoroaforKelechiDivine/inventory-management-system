package com.mintyn.inventorymanagement.service.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReport {

     private LocalDate date;

     private int totalOrders;

     private double totalAmount;
}
