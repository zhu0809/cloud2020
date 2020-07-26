package com.test.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Payment8002 {
//    private static final Logger logger = LoggerFactory.getLogger(Payment8002.class);

    public static void main(String[] args) {
        log.info("nihao s djf df dkfjdkf  ", Payment8002.class);

        SpringApplication.run(Payment8002.class, args);
    }
}
