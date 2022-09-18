package com.calculator.shippingrate.repository;

import com.calculator.shippingrate.entity.ShippingRateDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRateDetailEntity, Long> {
}
