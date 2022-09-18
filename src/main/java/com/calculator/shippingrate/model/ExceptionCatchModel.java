package com.calculator.shippingrate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExceptionCatchModel {
    private static final long serialVersionUID = -67978941L;

    private String errorCode;
    private String errorMessage;
}
