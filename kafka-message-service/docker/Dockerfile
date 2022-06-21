FROM        wonderd/jre:17
LABEL       app=kafka-message-service
RUN         addgroup --system app && adduser --system --no-create-home --ingroup app app && apk add --no-cache gcompat
USER        app
COPY        package/dependency      /opt/app
COPY        package/app             /opt/app
USER        root
RUN         chmod +x /opt/app/bin/kafka-message-service
USER        app
CMD         ["/opt/app/bin/kafka-message-service"]