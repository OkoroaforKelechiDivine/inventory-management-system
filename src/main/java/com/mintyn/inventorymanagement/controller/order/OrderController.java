package com.mintyn.inventorymanagement.controller.order;

import com.mintyn.inventorymanagement.dto.OrderReport;
import com.mintyn.inventorymanagement.exception.OutOfStockException;
import com.mintyn.inventorymanagement.models.order.OrderItem;
import com.mintyn.inventorymanagement.models.order.OrderRequest;
import com.mintyn.inventorymanagement.repository.order.OrderReportRepository;
import com.mintyn.inventorymanagement.repository.order.OrderRepository;
import com.mintyn.inventorymanagement.service.order.OrderServiceImplementation;
import com.mintyn.inventorymanagement.service.order.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
public class OrderController {

    @Autowired
    private OrderServiceImplementation orderServiceImplementation;

    @Autowired
    OrderReportRepository orderReportRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ReportService reportService;

    @PostMapping("/")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        try{
            OrderItem newOrderItem = orderServiceImplementation.createOrder(orderRequest);
            return ResponseEntity.ok(newOrderItem);
        }
        catch (OutOfStockException outOfStockException){
            return ResponseEntity.badRequest().body(outOfStockException.getMessage());
        }
    }

    @GetMapping("/reports")
    public List<OrderReport> getOrderReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reportService.generateOrderReport(startDate, endDate);
    }
}
