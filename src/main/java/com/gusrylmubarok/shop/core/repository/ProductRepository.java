package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
