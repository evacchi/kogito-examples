package com.myspace.demo;

import java.util.Map;
import java.util.HashMap;

public class OrderItemsModel {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap();
        params.put("item", this.item);
        params.put("order", this.order);
        return params;
    }

    public void fromMap(Long id, Map<String, Object> params) {
        this.id = id;
        this.item = (java.lang.String) params.get("item");
        this.order = (com.myspace.demo.Order) params.get("order");
    }

    private java.lang.String item;

    public java.lang.String getItem() {
        return item;
    }

    public void setItem(java.lang.String item) {
        this.item = item;
    }

    private com.myspace.demo.Order order;

    public com.myspace.demo.Order getOrder() {
        return order;
    }

    public void setOrder(com.myspace.demo.Order order) {
        this.order = order;
    }
}
