package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
