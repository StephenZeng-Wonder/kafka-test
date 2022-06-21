package app.test;

import app.test.dto.TestMessage;
import app.test.kafka.KafkaTestMessageHandler;
import core.framework.module.Module;

/**
 * @author stephen
 */
public class KafkaMessageConsumerModule extends Module {
    @Override
    protected void initialize() {
        kafka().subscribe(Constants.TEST_TOPIC, TestMessage.class, bind(KafkaTestMessageHandler.class));
    }
}
