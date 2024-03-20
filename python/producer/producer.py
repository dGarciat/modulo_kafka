from kafka import KafkaProducer
import sys

bootstrap_servers = 'localhost:9092,localhost:9093,localhost:9094'
topic = 'wordTopic'

producer = KafkaProducer(bootstrap_servers=bootstrap_servers)

try:
    while True:
        frase = input("Escribe una frase para enviar al tópico de Kafka ('exit' para salir): ")
        if frase.lower() == 'exit':
            break
        producer.send(topic, frase.encode('utf-8'))
        print("Frase enviada al tópico de Kafka.")
except KeyboardInterrupt:
    print("\n¡Proceso interrumpido por el usuario!")

producer.close()
