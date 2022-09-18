package com.calculator.shippingrate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShippingRateModel implements Serializable {
    private static final long serialVersionUID = -1L;

    private String errorCode;
    private String errorMessage;
    private Long id;
    private String shippingTo; // International or Domestic
    private String senderPostcode;
    private String receiverPostcode;
    private String shippingType;
    private String weight;
    private String packageLength;
    private String packageWidth;
    private String packageHeight;
    private String volumeWeight;
}
