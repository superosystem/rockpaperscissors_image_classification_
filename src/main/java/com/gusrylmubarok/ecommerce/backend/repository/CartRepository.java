package com.gusrylmubarok.ecommerce.backend.repository;

import com.gusrylmubarok.ecommerce.backend.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
