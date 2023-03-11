package com.mintyn.inventorymanagement.service.order;

import com.mintyn.inventorymanagement.models.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    private static final String TOPIC = "orders_topic";

    @Autowired
    private KafkaTemplate<String, OrderItem> kafkaTemplate;

    public void send(OrderItem orderItem) {
        kafkaTemplate.send(TOPIC, orderItem);
    }
}
