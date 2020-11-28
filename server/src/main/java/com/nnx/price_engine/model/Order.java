package com.nnx.price_engine.model;

import com.nnx.price_engine.common.enums.QuatityType;

public class Order {

    private Long productId;
    private QuatityType qtyType;
    private Long quantity;
    private String status;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public QuatityType getQtyType() {
        return qtyType;
    }

    public void setQtyType(QuatityType qtyType) {
        this.qtyType = qtyType;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
