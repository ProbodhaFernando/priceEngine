package com.nnx.price_engine.service;

import com.nnx.price_engine.common.enums.QuatityType;
import com.nnx.price_engine.model.Order;
import com.nnx.price_engine.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Override
    public Double getOrderTotalPrice(Order order) {
        Double totalCost;
        Product product = productService.getProductById(order.getProductId());
        if (QuatityType.UNIT.equals(order.getQtyType())) {
            totalCost = productService.calculateProductPriceByUnits(product, order.getQuantity());
        } else {
            totalCost = productService.calculateProductPriceByCartons(product, order.getQuantity());
        }
        return totalCost;
    }

}
