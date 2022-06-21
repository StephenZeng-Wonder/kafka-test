# kafka-test
core-ng kafka version compatibility test

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
kubectl apply 00-namespace.yml
kubectl apply 01-kafka-2.8.0.yml
kubectl apply 03-kafka-message-service.yml
```

### check service produce/consume kafka message normal

check pod logs in lens

### deploy new version kafka

```
kubectl apply 02-kafka-3.1.0.yml
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


