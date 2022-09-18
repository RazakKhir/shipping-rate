package com.calculator.shippingrate.controller;

import com.calculator.shippingrate.entity.ShippingRateEntity;
import com.calculator.shippingrate.model.ShippingRateModel;
import com.calculator.shippingrate.repository.ShippingRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShippingRateController {
    public static final String REQUEST_URL_SUBMIT_SHIPPING_INFO = "/submit/shipping-info";

    @Autowired
    ShippingRateRepository shippingRateRepository;

    @PostMapping(path = REQUEST_URL_SUBMIT_SHIPPING_INFO)
    public @ResponseBody
    ShippingRateModel submitShippingRateInfo(@RequestBody ShippingRateModel shippingRateModel) {
        ShippingRateModel returnShippingRateModel = new ShippingRateModel();
        ShippingRateEntity returnShippingRateEntity = new ShippingRateEntity();

        log.info("Start submitShippingRateInfo ... {}", shippingRateModel);
        try {
            log.info("save submitShippingRateInfo ...");
            returnShippingRateEntity = shippingRateRepository.save(toEntity(shippingRateModel));
            returnShippingRateModel = toModel(returnShippingRateEntity);
        } catch (Exception e){
            log.error(e.getMessage());
            shippingRateModel.setErrorCode("ERR001");
            shippingRateModel.setErrorMessage("Error in Saving data ... " + e.getMessage());
        }
        log.info("End submitShippingRateInfo ...");
        return returnShippingRateModel;
    }

    private ShippingRateEntity toEntity(ShippingRateModel shippingRateModel) {
        ShippingRateEntity shippingRateEntity = new ShippingRateEntity();
        try {
            shippingRateEntity.setShippingTo(shippingRateModel.getShippingTo());
            shippingRateEntity.setShippingType(shippingRateModel.getShippingType());
            shippingRateEntity.setSenderPostcode(shippingRateModel.getSenderPostcode());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return shippingRateEntity;
    }

    private ShippingRateModel toModel(ShippingRateEntity shippingRateEntity) {
        ShippingRateModel shippingRateModel = new ShippingRateModel();
        try {
            shippingRateModel.setShippingTo(shippingRateEntity.getShippingTo());
            shippingRateModel.setShippingType(shippingRateEntity.getShippingType());
            shippingRateModel.setSenderPostcode(shippingRateEntity.getSenderPostcode());
            shippingRateModel.setId(shippingRateEntity.getId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return shippingRateModel;
    }
}
