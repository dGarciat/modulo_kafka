import person_pb2
from confluent_kafka import Producer


def delivery_report(err, msg):
    if err is not None:
        print(f'Message delivery failed: {err}')
    else:
        print(f'Message delivered to {msg.topic()} [{msg.partition()}]')


def main():
    person = person_pb2.Person()
    person.first_name = "David"
    person.last_name = "García"
    person.birth_date = 28071987

    serialized_person = person.SerializeToString()

    producer = Producer({'bootstrap.servers': 'localhost:9092'})

    producer.produce('proto-topic', serialized_person, callback=delivery_report)

    producer.flush()


if __name__ == '__main__':
    main()
