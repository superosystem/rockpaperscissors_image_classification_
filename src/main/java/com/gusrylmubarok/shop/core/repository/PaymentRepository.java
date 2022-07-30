package com.gusrylmubarok.shop.core.repository;

import com.gusrylmubarok.shop.core.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
