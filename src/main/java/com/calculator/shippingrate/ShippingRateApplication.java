package com.calculator.shippingrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.calculator.shippingrate.controller"})
@ComponentScan({"com.calculator.shippingrate.service"})
public class ShippingRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingRateApplication.class, args);
    }

}
