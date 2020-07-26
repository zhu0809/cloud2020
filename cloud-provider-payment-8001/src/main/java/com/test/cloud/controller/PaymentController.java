package com.test.cloud.controller;


import com.test.cloud.entity.CommonResult;
import com.test.cloud.entity.Payment;
import com.test.cloud.service.PaymentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class PaymentController {

    Log log = LogFactory.getLog(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        int save = paymentService.save(payment);
        System.out.println(save);

        if (save > 0) {
            return new CommonResult<>(200, "成功  port:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) throws InterruptedException {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        if (null != payment) {
//            Thread.sleep(4000);
            return new CommonResult<>(200, "成功port:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "失败", null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
