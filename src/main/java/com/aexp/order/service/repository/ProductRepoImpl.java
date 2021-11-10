package com.aexp.order.service.repository;


import com.aexp.order.service.domain.product;
import com.aexp.order.service.repository.productRepo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements productRepo {

    Map<String, Integer> productMap = new HashMap<String, Integer>() {{
        put("apple", 60);
        put("orange", 25);
    }};

    @Override
    public Optional<product> findProduct(String productName) {

        Integer pricing = productMap.get(productName);
        if (productMap.get(productName) != null) {
            return Optional.of(new product(productName, pricing));
        }
        return Optional.empty();

    }
}
