from confluent_kafka import Consumer

conf = {'bootstrap.servers': 'localhost:9092',
        'group.id': "foo123",
        'enable.auto.commit': False,
        'auto.offset.reset': 'earliest',
        'isolation.level': 'read_committed'}

consumer = Consumer(conf)

topics = ['test']
consumer.subscribe(topics)
try:
    while True:
        msg = consumer.poll(timeout=1.0)
        if msg is not None:
            print(msg)
            consumer.commit(asynchronous=False)
except:
    print('Error')
