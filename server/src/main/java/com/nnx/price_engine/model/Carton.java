package com.nnx.price_engine.model;

public class Carton {
    private Long id;
    private Long productId;
    private Long unitsPerCarton;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public void setUnitsPerCarton(Long unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
