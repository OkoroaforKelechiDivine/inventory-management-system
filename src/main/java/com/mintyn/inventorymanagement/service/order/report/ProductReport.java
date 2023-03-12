package com.mintyn.inventorymanagement.service.order.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReport {

     private String productName;

     private Integer sales;

     private Double revenue;
}
