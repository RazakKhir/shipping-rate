package com.calculator.shippingrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.calculator.shippingrate.controller"})
public class ShippingRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingRateApplication.class, args);
    }

}
