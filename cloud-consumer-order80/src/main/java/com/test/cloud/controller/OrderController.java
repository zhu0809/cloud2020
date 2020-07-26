package com.test.cloud.controller;


import com.test.cloud.entity.CommonResult;
import com.test.cloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String payment_path = "http://PAYMENT-SERVICE/";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject("http://localhost:8001/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        return restTemplate.getForObject(payment_path + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment1/get/{id}")
    public Object create1(@PathVariable("id") Long id) {
        return restTemplate.getForEntity(payment_path + "/payment/get/" + id, CommonResult.class);
    }
}
