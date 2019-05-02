package com.myspace.demo;

import java.util.Map;

public class OrderItems_4_TaskInput {

    private Long _id;

    private String _name;

    public void setId(Long id) {
        this._id = id;
    }

    public Long getId() {
        return this._id;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    public static OrderItems_4_TaskInput fromMap(Long id, String name, Map<String, Object> params) {
        OrderItems_4_TaskInput item = new OrderItems_4_TaskInput();
        item._id = id;
        item._name = name;
        item.order = (com.myspace.demo.Order) params.get("order");
        return item;
    }

    private com.myspace.demo.Order order;

    public com.myspace.demo.Order getOrder() {
        return order;
    }

    public void setOrder(com.myspace.demo.Order order) {
        this.order = order;
    }
}
// Task input model for user task 'Add order items' in process 'demo.orderItems'
