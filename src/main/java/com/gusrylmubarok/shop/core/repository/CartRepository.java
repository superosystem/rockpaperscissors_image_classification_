package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c from Cart c join c.user u where u.id = :customerId")
    public Optional<Cart> findByCustomerId(@Param("customerId") Long customerId);
}
