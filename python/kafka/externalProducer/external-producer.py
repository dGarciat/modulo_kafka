import csv
import time
from confluent_kafka import Producer, KafkaError
import socket

def main():
    conf = {
        'bootstrap.servers': "localhost:9092",
        'client.id': socket.gethostname(),
        'transactional.id': 'external',
        'enable.idempotence': True
    }

    producer = Producer(conf)

    try:
        producer.init_transactions()
        with open('data.csv', 'r') as file:
            reader = csv.reader(file)
            for row in reader:
                send_kafka(producer, str(row))
                time.sleep(30)
    except Exception as e:
        print(f"An error occurred: {e}")

def send_kafka(producer, message):
    try:
        producer.begin_transaction()

        producer.produce('external_topic', value=message)

        producer.commit_transaction()
        print("Message sent")
    except KafkaError as e:
        producer.abort_transaction()
        print(f"Error sending message: {e}")

if __name__ == '__main__':
    main()
