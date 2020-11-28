package com.nnx.price_engine.service;

import com.nnx.price_engine.dao.ProductDao;
import com.nnx.price_engine.model.Carton;
import com.nnx.price_engine.model.Product;
import com.nnx.price_engine.model.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * This method is to get all products
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDao.getAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    /**
     * Method to retrieve all the Products and Price List till 50 units
     * @return ProductPrice List
     */
    @Override
    public List<ProductPrice> calculateProductPriceForAllProducts() {
        List<ProductPrice> productPriceList = new ArrayList<>();
        // Get all products list
         List<Product> products = (List<Product>) productDao.getAll();
        products.forEach(p -> {
            ProductPrice productPrice = new ProductPrice();
            productPrice.setProductName(p.getName());
            LinkedList<Double> priceList = new LinkedList<>();
            // iterate for 50 times and calculate the pricelist for each product
            for (int i = 1; i <= 50; i++) {
                // calculate price against no of units
                priceList.add(calculateProductPriceByUnits(p, (long) i));
            }
            productPrice.setPriceList(priceList);
            productPriceList.add(productPrice);
        });
        return productPriceList;
    }

    /**
     * This method is used to calculate the Optimized Price for the Product against the given Units.
     * @param product
     * @param units
     * @return Optimized price
     */
    @Override
    public Double calculateProductPriceByUnits(Product product, Long units) {
        Carton carton = productDao.getCartonByProductId(product.getId());
        Double cartonPrice = carton.getPrice();
        Long unitsPerCarton = carton.getUnitsPerCarton();

        //Adding 30% extra for Price of a Carton, when buying separate units
        Double pricePerUnit = (cartonPrice + (cartonPrice * 0.3)) / unitsPerCarton;

        Long noOfCartons = units/unitsPerCarton;
        Double priceForCartons = calculateCartonsPriceForProduct(carton, noOfCartons);

        Long remainingUnits = units % unitsPerCarton;
        Double priceForRemaningUnits = remainingUnits * pricePerUnit;

        return priceForCartons + priceForRemaningUnits;
    }

    /**
     * This method is used to calculate the Optimized Product Price based on the number of Cartons
     * @param product
     * @param noOfCartons
     * @return
     */
    @Override
    public Double calculateProductPriceByCartons(Product product, Long noOfCartons) {
        Carton carton = productDao.getCartonByProductId(product.getId());
        return calculateCartonsPriceForProduct(carton, noOfCartons);
    }

    /**
     * This method is to calculate optimized price for a Product against number of Cartons
     * @param carton
     * @param noOfCartons
     * @return Optimized price
     */
    @Override
    public Double calculateCartonsPriceForProduct(Carton carton, Long noOfCartons) {
        Double cartonPrice = carton.getPrice();
        if (noOfCartons >= 3) {
            cartonPrice = cartonPrice - (cartonPrice * 10/100);
        }
        return cartonPrice * noOfCartons;
    }
}
