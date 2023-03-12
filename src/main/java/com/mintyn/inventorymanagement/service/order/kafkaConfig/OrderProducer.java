package com.mintyn.inventorymanagement.service.order.kafkaConfig;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderProducer {

    private static final String TOPIC = "orderItems-consumer";

    @Autowired
    private KafkaTemplate<String, OrderItem> kafkaTemplate;

    public void sendMessage(OrderItem orderItem) {
        kafkaTemplate.send(TOPIC,  orderItem);
        log.info("Sending order item -> {}", orderItem);
    }
}
