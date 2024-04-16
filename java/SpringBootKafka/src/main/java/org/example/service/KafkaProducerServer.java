package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServer {

    @Autowired
    private KafkaTemplate<String, String> producerTemplate;


    @KafkaListener(topics = "external_topic", groupId = "spring-boot-kafka")
    private void consumer(String message) {
        System.out.println("Consumer received: " + message);
        if (filterAge(message)) {
            System.out.println("Cumple validación de edad");
            producerTemplate.send("internal_topic", message);
        }
    }

    private boolean filterAge(String message) {
        String[] parts = message.replace("'", "").split(",");
        return Integer.parseInt(parts[4].trim()) > 18 && Integer.parseInt(parts[4].trim()) <= 40;
    }

}
