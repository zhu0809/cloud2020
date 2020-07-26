package com.test.cloud.service;


import com.test.cloud.entity.Payment;

/**
 * @version demo2020-1.0
 * @Title: PaymentService
 * @Description:
 * @Company:
 * @author: chenlf
 * @date: 2020/5/26 10:55
 */
public interface PaymentService {
    /**
     * 保存
     *
     * @param payment
     * @return
     */
    int save(Payment payment);


    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
