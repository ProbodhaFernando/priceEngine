package com.nnx.price_engine.dao;

import com.nnx.price_engine.model.Carton;
import com.nnx.price_engine.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product getProductById(Long productId) {
        Product p = new Product();
        if (productId.equals(1L)) {
            p.setId(1L);
            p.setName("Penguin-ears");
            p.setType("RARE");
        } else {
            p.setId(2L);
            p.setName("Horseshoe");
            p.setType("");
        }
        return p;
    }

    @Override
    public Carton getCartonByProductId(Long productId) {
        Carton carton = new Carton();
        carton.setProductId(productId);
        if (productId.equals(1L)) {
            carton.setId(1L);
            carton.setPrice(new Double(175.00));
            carton.setUnitsPerCarton(20L);
        } else {
            carton.setId(2L);
            carton.setPrice(new Double(825.00));
            carton.setUnitsPerCarton(5L);
        }
        return carton;
    }

    @Override
    public Collection<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1L);
        p1.setName("Penguin-ears");
        p1.setType("RARE");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setName("Horseshoe");
        p2.setType("");

        products.add(p1);
        products.add(p2);
        return products;
    }
}
