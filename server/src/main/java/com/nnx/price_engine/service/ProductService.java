package com.nnx.price_engine.service;

import com.nnx.price_engine.model.Carton;
import com.nnx.price_engine.model.Product;
import com.nnx.price_engine.model.ProductPrice;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<ProductPrice> calculateProductPriceForAllProducts();

    Double calculateProductPriceByUnits(Product product, Long units);

    Double calculateProductPriceByCartons(Product product, Long noOfCartons);

    Double calculateCartonsPriceForProduct(Carton carton, Long noOfCartons);
}
