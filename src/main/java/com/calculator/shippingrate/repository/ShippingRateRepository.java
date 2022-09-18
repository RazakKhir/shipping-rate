package com.calculator.shippingrate.repository;

import com.calculator.shippingrate.entity.ShippingRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRateEntity, Long> {
}
