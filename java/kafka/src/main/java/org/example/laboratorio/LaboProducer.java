package org.example.laboratorio;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class LaboProducer {

    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        String topic = "labo-kafka";

        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Escribe una frase para enviar al tópico de Kafka ('exit' para salir): ");
                String frase = scanner.nextLine();
                if (frase.equalsIgnoreCase("exit")) {
                    break;
                }
                producer.send(new ProducerRecord<>(topic, frase));
                System.out.println("Frase enviada al tópico de Kafka.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
