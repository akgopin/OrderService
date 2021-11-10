package com.aexp.order.service.repository;


import com.aexp.order.service.domain.product;

import java.util.Optional;

public interface productRepo {

     Optional<product> findProduct(String productName);
}
