package org.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumerIdempotente {



    public static void main(String[] args) {


        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "temp-event-group");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");
        props.put("isolation.level", "read_committed");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(List.of("test"));
        try {
            while (true) {
                ConsumerRecords<String, String> events = consumer.poll(Duration.ofMillis(10000));
                for (ConsumerRecord<String, String> event : events) {
                    System.out.println(String.format("--- Partition={}, Offset={}, key={}, value={}",
                            event.partition(),
                            event.offset(),
                            event.key(),
                            event.value()));
                    consumer.commitAsync();
                }
            }
        } catch (Exception we) {
        }

    }
}
