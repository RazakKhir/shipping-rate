package com.calculator.shippingrate.repository;

import com.calculator.shippingrate.entity.ShippingRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.UUID;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRateEntity, UUID> {
}
