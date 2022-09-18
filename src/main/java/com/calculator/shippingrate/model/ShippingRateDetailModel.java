package com.calculator.shippingrate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShippingRateDetailModel extends ExceptionCatchModel {
    private static final long serialVersionUID = -145L;

    private Long id;
    private String logisticComp; // jnt or city
    private String senderPostcode;
    private String receiverPostcode;
    private String destinationCountry;
    private String weight;
    private String width;
    private String length;
    private String height;
    private String totalRate;
}
