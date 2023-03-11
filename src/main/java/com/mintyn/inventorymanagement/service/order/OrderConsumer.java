package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private static final String TOPIC = "orderItems-topic";

    @Autowired
    private ReportService reportService;

    @KafkaListener(topics = TOPIC, groupId = "consumer-38826-1-1")
    public void consume(OrderItem orderItem) {
        reportService.processOrder(orderItem);
    }
}
