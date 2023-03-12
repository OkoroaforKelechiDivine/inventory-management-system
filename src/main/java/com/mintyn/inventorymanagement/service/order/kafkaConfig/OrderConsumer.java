package com.mintyn.inventorymanagement.service.order.kafkaConfig;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import com.mintyn.inventorymanagement.service.order.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private static final String TOPIC = "orderItems-consumer";

    @Autowired
    private ReportService reportService;

    @KafkaListener(topics = TOPIC, groupId = "spring-boot-kafka")
    public void consume(OrderItem orderItem) {
        reportService.processOrder(orderItem);
    }
}
