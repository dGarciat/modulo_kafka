import json
import requests
from confluent_kafka import SerializingProducer
from confluent_kafka.schema_registry import SchemaRegistryClient
from confluent_kafka.schema_registry.avro import AvroSerializer

def stream(url):
    response = requests.get(url)
    return response.text

def main():
    url = "http://localhost:8081/subjects/person/versions/1"
    schema_str = stream(url)
    schema_json = json.loads(schema_str)
    schema = schema_json['schema']

    generic_record = {
        "firstName": "David",
        "lastName": "García",
        "birthDate": 28071987
    }

    schema_registry_conf = {'url': 'http://localhost:8081'}
    schema_registry_client = SchemaRegistryClient(schema_registry_conf)

    avro_serializer = AvroSerializer(schema_registry_client, schema)

    producer_conf = {
        'bootstrap.servers': '127.0.0.1:9092',
        'key.serializer': avro_serializer,
        'value.serializer': avro_serializer
    }

    producer = SerializingProducer(producer_conf)
    producer.produce(topic='generic-record', value=generic_record)
    producer.flush()

if __name__ == '__main__':
    main()
