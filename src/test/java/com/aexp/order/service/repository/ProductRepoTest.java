package com.aexp.order.service.repository;

import com.aexp.order.service.domain.product;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Optional;

public class ProductRepoTest {

    @Test
    public void TestValidProducts() {
        productRepo productRepo = new ProductRepoImpl();
        Optional<product> actualProduct = productRepo.findProduct("orange");
        product expectedProduct = new product("orange", 25);
        assertThat(actualProduct.get().getName(), equalTo(expectedProduct.getName()));
        assertThat(actualProduct.get().getPrice(), equalTo(expectedProduct.getPrice()));
    }

    @Test
    public void TestInValidProducts() {
        productRepo productRepo = new ProductRepoImpl();
        Optional<product> actualProduct = productRepo.findProduct("grapes");
        assertThat(actualProduct, equalTo(Optional.empty()));
    }
}
