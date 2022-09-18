package com.calculator.shippingrate.controller;

import com.calculator.shippingrate.model.ShippingRateDetailModel;
import com.calculator.shippingrate.service.ShippingRateSO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShippingRateController {
    public static final String REQUEST_URL_SUBMIT_SHIPPING_INFO = "/submit/shipping-info";

    @Autowired
    ShippingRateSO shippingRateSO;

    @PostMapping(path = REQUEST_URL_SUBMIT_SHIPPING_INFO)
    public @ResponseBody
    ResponseEntity<ShippingRateDetailModel> submitShippingRateInfo(@RequestBody ShippingRateDetailModel shippingRateDetailModel) {
        ShippingRateDetailModel returnShippingRateModel = new ShippingRateDetailModel();

        log.info("Start to save shipping information ... {}", REQUEST_URL_SUBMIT_SHIPPING_INFO);
        try {
            return new ResponseEntity<>(shippingRateSO.saveShippingInfo(shippingRateDetailModel), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            returnShippingRateModel.setErrorCode("ERR001");
            returnShippingRateModel.setErrorMessage("Error in Saving data ... " + e.getMessage());
            return new ResponseEntity<>(shippingRateSO.saveShippingInfo(returnShippingRateModel), HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
