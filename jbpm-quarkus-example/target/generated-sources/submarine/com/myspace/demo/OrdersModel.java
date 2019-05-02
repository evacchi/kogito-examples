package com.myspace.demo;

import java.util.Map;
import java.util.HashMap;

public class OrdersModel {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap();
        params.put("approver", this.approver);
        params.put("order", this.order);
        return params;
    }

    public void fromMap(Long id, Map<String, Object> params) {
        this.id = id;
        this.approver = (java.lang.String) params.get("approver");
        this.order = (com.myspace.demo.Order) params.get("order");
    }

    private java.lang.String approver;

    public java.lang.String getApprover() {
        return approver;
    }

    public void setApprover(java.lang.String approver) {
        this.approver = approver;
    }

    private com.myspace.demo.Order order;

    public com.myspace.demo.Order getOrder() {
        return order;
    }

    public void setOrder(com.myspace.demo.Order order) {
        this.order = order;
    }
}
