package com.test.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient

@RestController
public class CloudConfigCenter3355 {

    @Value("${config.info}")
    private String configInfo;

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3355.class, args);
    }

    @GetMapping("/configInfo")
    public String configInfo() {
        return configInfo;
    }
}
