package com.step.name.model;

import java.util.Objects;

public class OrderGood {

    private long id;

    private long order_id;

    private long good_id;

    public OrderGood(long id) {
        this.id = id;
    }

    public OrderGood(long id, long order_id) {
        this.id = id;
        this.order_id = order_id;
    }

    public OrderGood(long id, long order_id, long good_id) {
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
        OrderGood that = (OrderGood) o;
        return id == that.id && order_id == that.order_id && good_id == that.good_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_id, good_id);
    }

    @Override
    public String toString() {
        return "OrderGood{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", good_id=" + good_id +
                '}';
    }
}
