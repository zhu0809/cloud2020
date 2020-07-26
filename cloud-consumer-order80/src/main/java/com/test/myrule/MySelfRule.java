package com.test.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MySelfRule {
    public MySelfRule() {
        System.out.println("skjksdjfkjdkjdkjfdkj");
    }

    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RetryRule();
    }
}

