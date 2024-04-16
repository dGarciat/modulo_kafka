from kafka import KafkaConsumer

bootstrap_servers = 'localhost:9092'
topic = 'labo-kafka'
group_id = 'wordCount'
consumer = KafkaConsumer(topic, group_id=group_id, bootstrap_servers=bootstrap_servers)
wordCounts = {}

while True:
    message = next(consumer)
    for word in message.value.decode('utf-8').split():
        if word in wordCounts:
            wordCounts[word] += 1
        else:
            wordCounts[word] = 1
        
        print(f"char: {word}, count: {wordCounts[word]}")