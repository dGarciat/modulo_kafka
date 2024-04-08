package org.example.protoBuf;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class ProtoProducer {

    public static void main(String[] args) {

        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setFirstName("David")
                .setLastName("García")
                .setBirthDate(28071987)
                .build();

        byte[] serializedPerson = person.toByteArray();

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);

        producer.send(new ProducerRecord<String, byte[]>("proto-topic", serializedPerson));
        producer.close();
    }
}
