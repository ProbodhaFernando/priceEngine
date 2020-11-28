package com.nnx.price_engine.controller;

import com.nnx.price_engine.model.Order;
import com.nnx.price_engine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Double getOrderTotalPrice(@RequestBody Order order) {
        return orderService.getOrderTotalPrice(order);
    }

}
