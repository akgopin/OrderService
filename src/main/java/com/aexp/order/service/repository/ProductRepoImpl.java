package com.aexp.order.service.repository;


import com.aexp.order.service.domain.offer;
import com.aexp.order.service.domain.product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements productRepo {

    Map<String, product> productMap = new HashMap<String, product>() {{
        put("apple", new product("apple", 60, new offer(1, "Buy one get one")));
        put("orange", new product("orange", 25, new offer(2, "3 for the price of 2")));
    }};


    @Override
    public Optional<product> findProduct(String productName) {

        product product = productMap.get(productName);
        if (productMap.get(productName) != null) {
            return Optional.of(product);
        }
        return Optional.empty();

    }
}
