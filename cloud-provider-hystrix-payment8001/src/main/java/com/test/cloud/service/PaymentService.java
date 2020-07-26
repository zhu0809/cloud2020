package com.test.cloud.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * @author zzyy
 * @create 2020/3/6 22:23
 **/
@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK ,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {

        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut ,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    public String payment_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " payment_TimeOutHandler : ~~~~~~~~~";
    }

    /*=========  服务  熔断   ==============*/

    /**
     * circuitBreaker.enabled 是否开启熔断机制，默认为true。
     * circuitBreaker.forceOpen 强制开启熔断，默认为false。
     * circuitBreaker.forceClosed 强制关闭熔断，默认为false。
     * circuitBreaker.sleepWindowInMilliseconds  熔断窗口时间，默认为5s。
     * circuitBreaker.requestVolumeThreshold 当在配置时间窗口内达到此数量后的失败，进行短路。默认20个
     * circuitBreaker.errorThresholdPercentage 出错百分比阈值，当达到此阈值后，开始短路。默认50%
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod_circuit_Breaker", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //  是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 当在配置时间窗口内达到此数量后的失败，进行短路。默认20个
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")}) //失败率达到多少后跳闸
    public String fallbackMethod_circuit(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("id: 不能够小于0");
        }
        return Thread.currentThread().getName() + "调用成功 ----  流水号" + UUID.randomUUID().toString();
    }

    public String fallbackMethod_circuit_Breaker(@PathVariable("id") Long id) {
        return "id: 不能够小于0  我是熔断";
    }

}