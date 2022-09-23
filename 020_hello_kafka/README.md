### hello kafka

Imitation of https://www.sohamkamani.com/golang/working-with-kafka/

#### create a topic

```bash
$ docker-compose exec kafka-1 kafka-topics --create --bootstrap-server \
  localhost:9092 --replication-factor 3 --partitions 3 --topic hello-kafka
```
