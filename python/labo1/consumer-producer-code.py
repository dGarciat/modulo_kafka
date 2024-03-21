from kafka import KafkaProducer
from kafka import KafkaConsumer

import base64

bootstrap_servers = 'localhost:9092'
in_topic = 'labo-kafka'
out_topic = 'kafka-codificado'
group_id = 'code'


consumer = KafkaConsumer(in_topic, group_id=group_id, bootstrap_servers=bootstrap_servers)
producer = KafkaProducer(bootstrap_servers=bootstrap_servers)


for message in consumer:
    msj64 = base64.b64encode(message.value.decode('utf-8').encode()).decode()
    print(f'mensaje antes de conversión: {message.topic}, después: {msj64}')

    producer.send(out_topic, msj64.encode('utf-8'))
