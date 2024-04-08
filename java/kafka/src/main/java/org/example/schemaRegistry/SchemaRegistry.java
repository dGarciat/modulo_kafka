package org.example.schemaRegistry;

import com.google.gson.Gson;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class SchemaRegistry {
    public static void main(String[] args) throws IOException, InterruptedException {
        URL url = new URL("http://localhost:8081/subjects/person/versions/1");

        Gson gson = new Gson();
        gson.fromJson(stream(url).toString(), Map.class);
        Map<String, Object> map = gson.fromJson(stream(url), Map.class);


        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(map.get("schema").toString());
        GenericRecord genericRecord = new GenericData.Record(schema);
        genericRecord.put("firstName", "David");
        genericRecord.put("lastName", "García");
        genericRecord.put("birthDate", 28071987L);


        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        properties.put("schema.registry.url", "http://localhost:8081");

        KafkaProducer<String, GenericRecord> producer = new KafkaProducer<String, GenericRecord>(properties);
        producer.send(new ProducerRecord<>("generic-record", genericRecord));
        producer.flush();
    }

    public static String stream(URL url) throws IOException {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
    }
}
