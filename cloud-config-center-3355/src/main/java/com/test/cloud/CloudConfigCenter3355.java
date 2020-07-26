package com.test.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class CloudConfigCenter3355 {


    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3355.class, args);
    }


}
