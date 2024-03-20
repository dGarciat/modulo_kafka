from kafka import KafkaConsumer

bootstrap_servers = 'localhost:9092'
topic = 'mi_topico'
consumer = KafkaConsumer(topic, bootstrap_servers=bootstrap_servers)

while True:
    message = next(consumer)
    print(f"Clave: {message.key.decode('utf-8')}, Valor: {message.value.decode('utf-8')}")
