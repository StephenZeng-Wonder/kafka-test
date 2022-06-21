package app.test.job;

import app.test.dto.TestMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author stephen
 */
public class KafkaMessageProducerJob implements Job {
    @Inject
    private MessagePublisher<TestMessage> publisher;

    @Override
    public void execute(JobContext context) throws Exception {
        TestMessage message = new TestMessage();
        message.dateTimeField = LocalDateTime.now(ZoneId.of("America/New_York"));
        message.stringField = message.dateTimeField.toString();
        message.enumField = TestMessage.TestEnum.VALUE1;
        message.zonedDateTimeField = ZonedDateTime.now();
        message.childField = new TestMessage.Child();
        message.childField.booleanField = Boolean.FALSE;
        message.childrenField = new ArrayList<>();
        message.childrenField.add(new TestMessage.Child());
        message.mapField = new HashMap<>();
        message.mapField.put("key1", "value1");
        publisher.publish(message);
    }
}
