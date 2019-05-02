package com.myspace.demo;

import java.util.Map;
import java.util.HashMap;

public class OrderItems_4_TaskOutput {

    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap();
        params.put("item", this.item);
        return params;
    }

    private java.lang.String item;

    public java.lang.String getItem() {
        return item;
    }

    public void setItem(java.lang.String item) {
        this.item = item;
    }
}
// Task output model for user task 'Add order items' in process 'demo.orderItems'
