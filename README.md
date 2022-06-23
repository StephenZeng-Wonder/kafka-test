# kafka-test
core-ng kafka version compatibility test

# 2022-06-23 update

### add 3.1.0 kafka

```
kubectl apply -f 04-kafka-3.1.0.yml
```
connect to kafka version 3.1.0 please use service
```
sys.kafka.uri=kafka-v3:9092
```
connect to kafka that do downtime upgrade use service
```
sys.kafka.uri=kafka:9092
```

# test steps

### check out repo

```
git clone git@github.com:StephenZeng-Wonder/kafka-test.git
```

### build core-ng service image

```
./gradlew :kafka-message-service:docker
./env/init/build-image.sh
```

### deploy kube resource

```
kubectl apply -f 00-namespace.yml
kubectl apply -f 01-kafka-2.8.0.yml
kubectl apply -f 03-kafka-message-service.yml
```

### check service produce/consume kafka message normal

check pod logs in lens

### deploy new version kafka

```
kubectl apply -f 02-kafka-3.1.0.yml
```

delete kafka old pod

### check service produce/consume kafka message normal

check pod logs in lens

check message not missed

### calc downtime

using zoned_date_time_field value sub current_date_time_in_log

test result 1

![image](https://user-images.githubusercontent.com/90366906/174776481-9e48a8c1-c8d9-4470-826b-3a1a841cfe7c.png)

test result 2

![image](https://user-images.githubusercontent.com/90366906/174776802-5f27a1b0-4870-4917-bcec-4603dac82a39.png)


