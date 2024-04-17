package org.curso.kafka.ejercicios;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.curso.kafka.aggregate.StatelessApp;
import org.json.JSONObject;

import static org.curso.kafka.utils.KafkaStreamProperties.*;
import static org.curso.kafka.utils.StreamUtils.printStream;

/*
Crea un Pipeline en kafka-stream al cual recibirá datos de la aplicación KafkaStreamsApp/org.curso.kafka.Sender en formato json.
 El Pipeline consistirán en filtrar aquellos eventos cuya clave (key sea par) y escribe en el tópico out.industry
  el valor del campo Industry_name_NZSIOC y el tópico out.category el valor del campo Variable_category.
 */
public class Ejer1 {

    public static void main(String[] args) {

        final StreamsBuilder builder = new StreamsBuilder();

        final KStream<Long, String> stream = builder.stream(TOPIC_IN);

        printStream("Source", stream);

        // Map
        KStream<Long, JSONObject> jsonStream = stream
                .map((k, v) -> new KeyValue<>(k, new JSONObject(v)));

        printStream("Map", jsonStream);

        // Filter
        KStream<Long, JSONObject> filterStream = jsonStream
                .filter((k, v) -> k % 2 == 0);

        printStream("Filter", filterStream);


        KStream<Long, String> industryStream = filterStream
                .map((k, v) -> new KeyValue<>(k, v.getString("Industry_name_NZSIOC")));

        KStream<Long, String> categoryStream = filterStream
                .map((k, v) -> new KeyValue<>(k, v.getString("Variable_category")));


        printStream("Industry", industryStream);
        printStream("Category", categoryStream);

        // Sink
        industryStream
                .map((k, v) -> new KeyValue<>(k, v.toString()))
                .to(TOPIC_OUT_B);

        categoryStream
                .map((k, v) -> new KeyValue<>(k, v.toString()))
                .to(TOPIC_OUT_C);




        Topology topology = builder.build();

        KafkaStreams kafkaStreams = new KafkaStreams(topology, getKafkaStreamProperties("curso.stateless"));
        kafkaStreams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

    }

}
