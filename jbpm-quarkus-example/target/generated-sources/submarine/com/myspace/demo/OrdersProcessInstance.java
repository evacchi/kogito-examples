package com.myspace.demo;

public class OrdersProcessInstance extends org.kie.submarine.process.impl.AbstractProcessInstance<OrdersModel> {

    public OrdersProcessInstance(com.myspace.demo.OrdersProcess process, OrdersModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    protected java.util.Map<String, Object> bind(OrdersModel variables) {
        return variables.toMap();
    }

    protected void unbind(OrdersModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
