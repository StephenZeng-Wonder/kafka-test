package app.test.kafka;

import app.test.dto.TestMessage;
import core.framework.json.JSON;
import core.framework.kafka.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

/**
 * @author stephen
 */
public class KafkaTestMessageHandler implements MessageHandler<TestMessage> {
    private final Logger logger = LoggerFactory.getLogger(KafkaTestMessageHandler.class);
    @Override
    public void handle(@Nullable String key, TestMessage value) throws Exception {
        logger.info(JSON.toJSON(value));
    }
}
