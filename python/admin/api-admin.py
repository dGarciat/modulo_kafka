import time
from confluent_kafka.admin import AdminClient, NewTopic

conf = {'bootstrap.servers': "localhost:9092"}

# AdminClient
admin_client = AdminClient(conf)

# conf
topic_name = "mi_topico"
num_partitions = 3
replication_factor = 1

# Crear el objeto NewTopic
new_topic = NewTopic(topic_name, num_partitions, replication_factor)

# Crear el tópico utilizando el AdminClient
admin_client.create_topics([new_topic])

# Esperar a que el tema se cree
topics = admin_client.list_topics().topics
while topic_name not in topics:
    topics = admin_client.list_topics().topics
    time.sleep(1)  # Espera 1 segundo antes de verificar nuevamente
