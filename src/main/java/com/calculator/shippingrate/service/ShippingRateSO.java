package com.calculator.shippingrate.service;

import com.calculator.shippingrate.model.ShippingRateDetailModel;
import org.springframework.stereotype.Component;

@Component
public interface ShippingRateSO {
    ShippingRateDetailModel saveShippingInfo(ShippingRateDetailModel shippingRateDetailModel);
    void jntWebScrapeProcess (ShippingRateDetailModel shippingRateDetailModel);
}
