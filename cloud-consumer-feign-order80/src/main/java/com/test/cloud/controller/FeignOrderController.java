package com.test.cloud.controller;

import com.test.cloud.entity.CommonResult;
import com.test.cloud.entity.Payment;
import com.test.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOrderController {
    @Autowired
    private PaymentFeignService feignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return feignService.get(id);
    }
}
