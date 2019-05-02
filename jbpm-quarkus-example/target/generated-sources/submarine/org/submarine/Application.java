package org.submarine;

import org.kie.submarine.Config;

@javax.inject.Singleton()
public class Application {

    public Config config() {
        return config;
    }

    public static org.kie.submarine.Config config = new org.kie.submarine.StaticConfig(new org.kie.submarine.process.impl.StaticProcessConfig(new org.kie.submarine.process.impl.DefaultWorkItemHandlerConfig(), new org.kie.submarine.process.impl.DefaultProcessEventListenerConfig()));

    public com.myspace.demo.OrdersProcess createOrdersProcess() {
        return new com.myspace.demo.OrdersProcess(this);
    }

    public com.myspace.demo.OrderItemsProcess createOrderItemsProcess() {
        return new com.myspace.demo.OrderItemsProcess(this);
    }
}
