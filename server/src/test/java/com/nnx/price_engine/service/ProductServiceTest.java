package com.nnx.price_engine.service;

import com.nnx.price_engine.dao.ProductDao;
import com.nnx.price_engine.model.Carton;
import com.nnx.price_engine.model.Product;
import com.nnx.price_engine.model.ProductPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @TestConfiguration
    static class ProductServiceTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }

    }

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductDao productDao;

    @BeforeEach
    public void setup() {
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

        Carton carton = new Carton();
        carton.setProductId(1L);
        carton.setId(1L);
        carton.setPrice(new Double(175.00));
        carton.setUnitsPerCarton(20L);


        Mockito.when(productDao.getAll()).thenReturn(products);
        Mockito.when(productDao.getProductById(ArgumentMatchers.anyLong())).thenReturn(p1);
        Mockito.when(productDao.getCartonByProductId(ArgumentMatchers.anyLong())).thenReturn(carton);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();

        Assertions.assertAll("Test for All products",
                () -> Assertions.assertEquals(products.get(0).getName(), "Penguin-ears"),
                () -> Assertions.assertEquals(products.get(1).getName(), "Horseshoe")
        );
    }

    @Test
    public void testGetProductById() {
        Product product = productService.getProductById(1L);
        Assertions.assertEquals("Penguin-ears", product.getName());
    }

    @Test
    public void testCalculateProductPriceForAllProducts() {
        List<ProductPrice> productPriceList = productService.calculateProductPriceForAllProducts();
        Assertions.assertEquals(2, productPriceList.size());
        Assertions.assertAll("ProductPrice test for all",
                () -> Assertions.assertEquals(50, productPriceList.get(0).getPriceList().size()),
                () -> Assertions.assertEquals(50, productPriceList.get(1).getPriceList().size())
        );
    }

    @Test
    public void testCalculateProductPriceByUnits() {
        Product product = new Product();
        product.setId(1L);

        Double priceForUnits = productService.calculateProductPriceByUnits(product, 20L);
        Assertions.assertEquals(new Double(175), priceForUnits);
    }

    @Test
    public void testCalculateProductPriceByCartons() {
        Product product = new Product();
        product.setId(1L);

        Double priceForCartons = productService.calculateProductPriceByCartons(product, 2L);
        Assertions.assertEquals(new Double(350), priceForCartons);
    }

    @Test
    public void testCalculateCartonsPriceForProduct() {
        Carton carton = new Carton();
        carton.setProductId(1L);
        carton.setId(1L);
        carton.setPrice(new Double(175.00));
        carton.setUnitsPerCarton(20L);

        Double cartonsPrice = productService.calculateCartonsPriceForProduct(carton, 2L);
        Assertions.assertEquals(new Double(350), cartonsPrice);
    }
}
