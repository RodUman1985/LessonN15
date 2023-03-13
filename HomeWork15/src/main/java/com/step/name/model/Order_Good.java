package com.step.name.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order_Good {

    private long id;

    private long order_id;

    private long good_id;

    public Order_Good(long id) {
        this.id = id;
    }

    public Order_Good(long id, long order_id) {
        this.id = id;
        this.order_id = order_id;
    }

    public Order_Good(long id, long order_id, long good_id) {
        this.id = id;
        this.order_id = order_id;
        this.good_id = good_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order_Good that = (Order_Good) o;
        return id == that.id && order_id == that.order_id && good_id == that.good_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_id, good_id);
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", good_id=" + good_id +
                '}';
    }
}
