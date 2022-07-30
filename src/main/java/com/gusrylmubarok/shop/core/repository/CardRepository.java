package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
