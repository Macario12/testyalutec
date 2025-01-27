package com.example.evaluacionyalutec.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String productName, int cantidad) {
        kafkaTemplate.send(topic, String.format("Producto ingresado nombre: %s y cantidad: %,d", productName, cantidad));
    }
}
