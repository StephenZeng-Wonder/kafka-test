#!/usr/bin/env bash

app="kafka-message-service"
image="wonder-lab/${app}"
acr="FtiDevAcr"
BUILD_ID="1"

az acr build --registry ${acr} --image ${image}:${BUILD_ID} --image ${image}:latest build/${app}/docker