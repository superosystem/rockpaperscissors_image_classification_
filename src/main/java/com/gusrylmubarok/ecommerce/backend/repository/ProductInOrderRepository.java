package com.gusrylmubarok.ecommerce.backend.repository;

import com.gusrylmubarok.ecommerce.backend.domain.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {
}
