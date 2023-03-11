package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.dto.OrderReport;
import com.mintyn.inventorymanagement.models.order.OrderItem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private Map<LocalDate, List<OrderItem>> ordersByDate = new HashMap<>();

    public void processOrder(OrderItem orderItem) {
        LocalDate orderDate = orderItem.getOrderDate();

        if (ordersByDate.containsKey(orderDate)) {
            ordersByDate.get(orderDate).add(orderItem);
        } else {
            List<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(orderItem);
            ordersByDate.put(orderDate, orderItems);
        }
    }

    public List<OrderReport> generateOrderReport(LocalDate startDate, LocalDate endDate) {
        List<OrderReport> report = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            List<OrderItem> orderItems = ordersByDate.get(date);
            if (orderItems != null) {
                int totalOrders = orderItems.size();
                double totalAmount = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
                report.add(new OrderReport(date, totalOrders, totalAmount));
            } else {
                report.add(new OrderReport(date, 0, 0.0));
            }
        }
        return report;
    }
}
