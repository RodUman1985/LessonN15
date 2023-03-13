package com.step.name.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private long id;

    private long userId;

    private BigDecimal total_prise;

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Order(long id, long userId, BigDecimal total_prise) {
        this.id = id;
        this.userId = userId;
        this.total_prise = total_prise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
        return id == order.id &&
                userId == order.userId &&
                Objects.equals(total_prise, order.total_prise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, total_prise);
    }

    @Override
    public String toString() {
        return "OrderDAO{" +
                "id=" + id +
                ", userId=" + userId +
                ", total_prise=" + total_prise +
                '}';
    }
}
