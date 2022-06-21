package app.test;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author stephen
 */
public class TestServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new KafkaMessageProducerModule());
        load(new KafkaMessageConsumerModule());
    }
}
