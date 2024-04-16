package org.curso.kafka.aggregate;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.json.JSONObject;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import static org.curso.kafka.utils.KafkaStreamProperties.*;
import static org.curso.kafka.utils.StreamUtils.printStream;

public class TansformApp {

    public static void main(String[] args) {

        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "reduce");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE_V2);
        config.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kStream");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());




        Topology topology = createTopology();

        KafkaStreams kafkaStreams = new KafkaStreams(topology, config);
        kafkaStreams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

    }


    public static Topology createTopology() {
        final StreamsBuilder builder = new StreamsBuilder();
        final KStream<String, String> stream = builder.stream("in");


        KStream<Object, Object> result = stream.transform(new CustomTransform());

        result.foreach((k, v)-> System.out.println(k + " - " + v));


//        kTable.toStream().to("out");


        return builder.build();
    }


}
