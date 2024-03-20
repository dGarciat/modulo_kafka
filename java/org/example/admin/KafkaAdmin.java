package org.example.admin;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import java.util.Collections;
import java.util.Properties;


public class KafkaAdmin {

    private final Admin admin;

    public KafkaAdmin(String bootstrapServers) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        this.admin = Admin.create(properties);
    }

    public synchronized void createTopic(String topic, int partitions, short replication) {
        admin.createTopics(Collections.singleton(new NewTopic(topic, partitions, replication)));
    }

    public static void main(String[] args) throws InterruptedException {
        String bootstrapServers = "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094";
        KafkaAdmin kafkaAdmin = new KafkaAdmin(bootstrapServers);
        kafkaAdmin.createTopic("mi-topic", 3, (short) 1);
        Thread.sleep(30000);
        System.out.println("Tema creado con éxito.");
    }

}


