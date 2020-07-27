package com.test.cloud;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigCenter3344 {

    public static void main(String[] args) {
        IdUtil.fastSimpleUUID();
        SpringApplication.run(CloudConfigCenter3344.class, args);
    }
}
