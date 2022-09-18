package com.calculator.shippingrate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "txn_shipping_rate_info")
//@AttributeOverride(name = "id", column = @Column(name = "shipRateId", columnDefinition = "binary(16)", unique = true, nullable = false))
public class ShippingRateEntity {
    private static final long serialVersionUID = -83090673381384334L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipRateId;

    @Column(name = "shippingTo")
    private String shippingTo; // International or Domestic

    @Column(name = "shippingType")
    private String shippingType;

    @Column(name = "senderPostcode")
    private String senderPostcode;
}
