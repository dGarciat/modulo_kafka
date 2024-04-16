from confluent_kafka import Producer
import socket

conf = {'bootstrap.servers': "localhost:9092",
        'client.id': socket.gethostname(),
       'transactional.id': 'productor.idem',
       'enable.idempotence': True}

producer = Producer(conf)
producer.init_transactions()
producer.begin_transaction()

try:
    value = 'Hello curso kafka'
    producer.produce('topic', key="key", value=value)

    producer.commit_transaction()
except:
    print('Error')
    producer.abort_transaction()
