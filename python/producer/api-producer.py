from kafka import KafkaProducer

bootstrap_servers = 'localhost:9092'

producer = KafkaProducer(bootstrap_servers=bootstrap_servers)

topic = 'mi_topico'

message = b'Hola, mundo!'
key = b'clave'

producer.send(topic, key=key, value=message)

producer.close()

