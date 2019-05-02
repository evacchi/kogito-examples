package com.myspace.demo;

public class OrderItemsProcessInstance extends org.kie.submarine.process.impl.AbstractProcessInstance<OrderItemsModel> {

    public OrderItemsProcessInstance(com.myspace.demo.OrderItemsProcess process, OrderItemsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    protected java.util.Map<String, Object> bind(OrderItemsModel variables) {
        return variables.toMap();
    }

    protected void unbind(OrderItemsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
