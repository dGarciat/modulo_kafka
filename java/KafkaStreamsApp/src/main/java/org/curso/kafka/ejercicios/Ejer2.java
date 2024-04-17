package org.curso.kafka.ejercicios;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.json.JSONObject;

import java.util.Properties;

import static org.curso.kafka.utils.KafkaStreamProperties.TOPIC_IN;
import static org.curso.kafka.utils.KafkaStreamProperties.getKafkaStreamProperties;

/*
Usando KafkaStreamsApp/org.curso.kafka.Sender envíe eventos un tópico y escriba una aplicación que cuente eventos que tengan el mismo año (campo Year).
 */
public class Ejer2 {

    public static void main(String[] args) {


        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "ejer2");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE_V2);
        config.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kStream");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        Topology topology = createTopology();

        KafkaStreams kafkaStreams = new KafkaStreams(topology, getKafkaStreamProperties("KafkaStreams"));
        kafkaStreams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

    }

    private static Topology createTopology() {

        final StreamsBuilder builder = new StreamsBuilder();
        final KStream<Long, String> stream = builder.stream(TOPIC_IN);



        return builder.build();

    }
}
