package app.test;

import app.test.dto.TestMessage;
import app.test.job.KafkaMessageProducerJob;
import core.framework.module.Module;

import java.time.Duration;

/**
 * @author stephen
 */
public class KafkaMessageProducerModule extends Module {
    @Override
    protected void initialize() {
        kafka().publish(Constants.TEST_TOPIC, TestMessage.class);
        schedule().fixedRate("kafka-message-producer-job", bind(KafkaMessageProducerJob.class), Duration.ofSeconds(1));
    }
}
