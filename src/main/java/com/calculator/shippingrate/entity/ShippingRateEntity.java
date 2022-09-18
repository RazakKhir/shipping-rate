package com.calculator.shippingrate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "txn_shipping_rate_info")
@AttributeOverride(name = "id", column = @Column(name = "shipRateId", columnDefinition = "binary(16)", unique = true, nullable = false))
public class ShippingRateEntity extends AbstractPersistable<UUID> {
    private static final long serialVersionUID = -83090673381384334L;

    public ShippingRateEntity() {
    }

    public ShippingRateEntity(UUID id) {
        this.setId(id);
    }

    private String shippingTo; // International or Domestic
    private String shippingType;
    private String senderPostcode;
}
