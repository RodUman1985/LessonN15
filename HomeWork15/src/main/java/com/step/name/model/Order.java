package com.step.name.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private long id;

    private long user_id;

    private BigDecimal total_prise;

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, long user_id) {
        this.id = id;
        this.user_id = user_id;
    }

    public Order(long id, long user_id, BigDecimal total_prise) {
        this.id = id;
        this.user_id = user_id;
        this.total_prise = total_prise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTotal_prise() {
        return total_prise;
    }

    public void setTotal_prise(BigDecimal total_prise) {
        this.total_prise = total_prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && user_id == order.user_id && Objects.equals(total_prise, order.total_prise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, total_prise);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", total_prise=" + total_prise +
                '}';
    }
}
