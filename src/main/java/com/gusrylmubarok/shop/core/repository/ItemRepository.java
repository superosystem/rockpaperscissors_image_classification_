package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select i.* from carts c, items i, users u, cart_item ci where u.id = :customerId and c.id_user=u.id and c.id=ci.id_cart and i.id=ci.id_item", nativeQuery = true)
    Iterable<Item> findByCustomerId(String customerId);

    @Modifying
    @Query(value = "delete from cart_item where item_id in (:ids) and cart_id = :cartId", nativeQuery = true)
    void deleteCartItemJoinById(List<Long> ids, Long cartId);
}
