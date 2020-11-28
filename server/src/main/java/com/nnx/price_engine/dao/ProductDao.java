package com.nnx.price_engine.dao;

import com.nnx.price_engine.model.Carton;
import com.nnx.price_engine.model.Product;

public interface ProductDao extends BaseDao<Product> {

    Product getProductById(Long productId);

    Carton getCartonByProductId(Long productId);
}
