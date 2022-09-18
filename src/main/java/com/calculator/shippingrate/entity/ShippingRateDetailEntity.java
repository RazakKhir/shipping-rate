package com.calculator.shippingrate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "txn_shipping_rate_detail")
public class ShippingRateDetailEntity {
    private static final long serialVersionUID = -78678671384334L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "logisticComp")
    private String logisticComp; // jnt or city
    @Column(name = "senderPostcode")
    private String senderPostcode;
    @Column(name = "receiverPostcode")
    private String receiverPostcode;
    @Column(name = "destinationCountry")
    private String destinationCountry;
    @Column(name = "weight")
    private String weight;
    @Column(name = "width")
    private String width;
    @Column(name = "length")
    private String length;
    @Column(name = "height")
    private String height;
    @Column(name = "totalRate")
    private String totalRate;
}
