package com.step.name.dao.impl;

import com.step.name.dao.OrderDAO;
import com.step.name.model.Order;

import java.util.Optional;

public class OrderDaoImpl implements OrderDAO {
    @Override
    public void createNewOrder(Order order) {

    }

    @Override
    public Optional<Order> GetByUserId(Long userId) {
        return Optional.empty();
    }
}
