package com.myspace.demo;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.inject.Singleton()
@javax.inject.Named("demo.orderItems")
public class OrderItemsProcess extends org.kie.submarine.process.impl.AbstractProcess<com.myspace.demo.OrderItemsModel> {

    org.submarine.Application app;

    public OrderItemsProcess() {
        this(new org.submarine.Application());
    }

    public OrderItemsProcess(org.submarine.Application app) {
        super(app.config().process());
        this.app = app;
    }

    public com.myspace.demo.OrderItemsProcessInstance createInstance(com.myspace.demo.OrderItemsModel value) {
        return new com.myspace.demo.OrderItemsProcessInstance(this, value, this.createLegacyProcessRuntime());
    }

    protected org.kie.api.definition.process.Process legacyProcess() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("demo.orderItems");
        factory.variable("order", new ObjectDataType("com.myspace.demo.Order"));
        factory.variable("item", new ObjectDataType("java.lang.String"));
        factory.name("orderItems");
        factory.packageName("com.myspace.demo");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Private");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory startNode1 = factory.startNode(1);
        startNode1.name("Start");
        startNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode2 = factory.actionNode(2);
        actionNode2.name("Show order details");
        actionNode2.action(kcontext -> {
            com.myspace.demo.Order order = (com.myspace.demo.Order) kcontext.getVariable("order");
            java.lang.String item = (java.lang.String) kcontext.getVariable("item");
            System.out.println("Order is " + order);

order.setTotal(55.0);
kcontext.setVariable("order", order);;
        });
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode3 = factory.endNode(3);
        endNode3.name("End");
        endNode3.terminate(false);
        endNode3.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory humanTaskNode4 = factory.humanTaskNode(4);
        humanTaskNode4.name("Add order items");
        humanTaskNode4.workParameter("Comment", "Order Items");
        humanTaskNode4.workParameter("TaskName", "AddOrderItems");
        humanTaskNode4.workParameter("NodeName", "Add order items");
        humanTaskNode4.workParameter("Skippable", "false");
        humanTaskNode4.workParameter("ActorId", "john");
        humanTaskNode4.inMapping("order", "order");
        humanTaskNode4.outMapping("item", "item");
        humanTaskNode4.done();
        factory.connection(1, 2, "_A318747C-A38A-4BDA-B7E2-484BC6D53B0C");
        factory.connection(4, 3, "_B8CF2403-AD85-4799-B01A-B80B18092D19");
        factory.connection(2, 4, "_BF9702AF-B09A-4EFF-A638-5FD3A1BE133C");
        factory.validate();
        return factory.getProcess();
    }
}
