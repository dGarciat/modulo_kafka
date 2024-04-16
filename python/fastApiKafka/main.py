from fastapi import FastAPI, HTTPException
from confluent_kafka import Consumer, Producer


app = FastAPI()

KAFKA_BOOTSTRAP_SERVERS = 'localhost:9092'
KAFKA_CONSUMER_TOPIC = 'external_topic'
KAFKA_PRODUCER_TOPIC = 'internal_topic'

consumer_config = {
    'bootstrap.servers': KAFKA_BOOTSTRAP_SERVERS,
    'group.id': 'fastApi-group',
    'auto.offset.reset': 'latest'
}

producer_config = {
    'bootstrap.servers': KAFKA_BOOTSTRAP_SERVERS
}

def consume_and_filter():
    consumer = Consumer(consumer_config)
    consumer.subscribe([KAFKA_CONSUMER_TOPIC])
    producer = Producer(producer_config)

    while True:
        msg = consumer.poll(1.0)
        if msg is None:
            continue
        if msg.error():
            raise HTTPException(status_code=500, detail=f"Error al consumir mensaje: {msg.error()}")
        else:
            try:
                age = int(msg.value().decode('utf-8').replace("'","").split(",")[4].strip())
                if 18 <= age <= 40:
                    print(f"Cumple validación")
                    producer.produce(KAFKA_PRODUCER_TOPIC, value=msg.value())
                    producer.flush()
            except Exception as e:
                print(f"Error al procesar mensaje: {e}")


@app.get("/")
async def root():
    consume_and_filter()
    return {"message": "Mensajes consumidos"}

