package com.nnx.price_engine.controller;

import com.nnx.price_engine.model.Product;
import com.nnx.price_engine.model.ProductPrice;
import com.nnx.price_engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productPrice")
    public List<ProductPrice> getAllProductPriceList() {
        return productService.calculateProductPriceForAllProducts();
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
