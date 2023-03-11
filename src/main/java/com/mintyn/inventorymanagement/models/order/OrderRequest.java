package com.mintyn.inventorymanagement.models.order;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {

    private String customerName;

    private int customerId;

    private int quantity;

    private String customerPhoneNumber;

    private int productId;
}
