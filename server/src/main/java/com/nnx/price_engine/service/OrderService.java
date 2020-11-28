package com.nnx.price_engine.service;

import com.nnx.price_engine.model.Order;

public interface OrderService {
    Double getOrderTotalPrice(Order order);
}
