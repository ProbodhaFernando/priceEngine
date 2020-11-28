package com.nnx.price_engine.model;

import java.util.LinkedList;

public class ProductPrice {
    private String productName;
    private LinkedList<Double> priceList;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LinkedList<Double> getPriceList() {
        return priceList;
    }

    public void setPriceList(LinkedList<Double> priceList) {
        this.priceList = priceList;
    }
}
