package com.calculator.shippingrate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShippingRateResultModel extends ExceptionCatchModel {
    private static final long serialVersionUID = -145L;

    private String logisticCompany;
    private String totalShippingRate;
}
