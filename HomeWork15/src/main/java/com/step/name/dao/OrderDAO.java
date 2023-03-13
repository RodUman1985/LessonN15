package com.step.name.dao;

import com.step.name.model.Order;

import java.util.Optional;

public interface OrderDAO {

    void createNewOrder(Order order);
    Optional<com.step.name.model.Order > GetByUserId(Long userId);
}
