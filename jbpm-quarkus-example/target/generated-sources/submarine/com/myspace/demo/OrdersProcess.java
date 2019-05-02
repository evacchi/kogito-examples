package com.myspace.demo;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.inject.Singleton()
@javax.inject.Named("demo.orders")
public class OrdersProcess extends org.kie.submarine.process.impl.AbstractProcess<com.myspace.demo.OrdersModel> {

    org.submarine.Application app;

    public OrdersProcess() {
        this(new org.submarine.Application());
    }

    public OrdersProcess(org.submarine.Application app) {
        super(app.config().process());
        this.app = app;
    }

    public com.myspace.demo.OrdersProcessInstance createInstance(com.myspace.demo.OrdersModel value) {
        return new com.myspace.demo.OrdersProcessInstance(this, value, this.createLegacyProcessRuntime());
    }

    protected org.kie.api.definition.process.Process legacyProcess() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("demo.orders");
        factory.variable("order", new ObjectDataType("com.myspace.demo.Order"));
        factory.variable("approver", new ObjectDataType("java.lang.String"));
        factory.name("orders");
        factory.packageName("com.myspace.demo");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("Documentation", "Deals with orders created by customer");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode1 = factory.actionNode(1);
        actionNode1.name("Dump order");
        actionNode1.action(kcontext -> {
            com.myspace.demo.Order order = (com.myspace.demo.Order) kcontext.getVariable("order");
            java.lang.String approver = (java.lang.String) kcontext.getVariable("approver");
            System.out.println("An order has been created " + order + " with assigned approver " + approver);;
        });
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory subProcessNode3 = factory.subProcessNode(3);
        subProcessNode3.name("Add items");
        subProcessNode3.processId("demo.orderItems");
        subProcessNode3.processName("");
        subProcessNode3.waitForCompletion(true);
        subProcessNode3.independent(false);
        subProcessNode3.subProcessFactory(new org.jbpm.workflow.core.node.SubProcessFactory<OrderItemsModel>() {

            public OrderItemsModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.myspace.demo.OrderItemsModel model = new com.myspace.demo.OrderItemsModel();
                com.myspace.demo.Order order = (com.myspace.demo.Order) kcontext.getVariable("order");
                model.setOrder((com.myspace.demo.Order) (order));
                return model;
            }

            public org.kie.submarine.process.ProcessInstance<OrderItemsModel> createInstance(OrderItemsModel model) {
                return app.createOrderItemsProcess().createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, OrderItemsModel model) {
                com.myspace.demo.Order order = (com.myspace.demo.Order) model.getOrder();
                kcontext.setVariable("order", order);
            }
        });
        subProcessNode3.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory startNode4 = factory.startNode(4);
        startNode4.name("Start");
        startNode4.done();
        factory.connection(4, 1, "_B7B4282B-F317-4BF9-95E9-962B046EE815");
        factory.connection(3, 2, "_8216C810-34D8-4BFA-B814-1AA01907810F");
        factory.connection(1, 3, "_58684613-0155-48B2-8746-7675AFF24439");
        factory.validate();
        return factory.getProcess();
    }
}
