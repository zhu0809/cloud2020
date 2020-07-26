package com.test.cloud.service.impl;


import com.test.cloud.dao.PaymentDAO;
import com.test.cloud.entity.Payment;
import com.test.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version demo2020-1.0
 * @Title: PaymentServiceImpl
 * @Description:
 * @Company:
 * @author: chenlf
 * @date: 2020/5/26 10:55
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDAO dao;

    @Override
    public int save(Payment payment) {
        return dao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return dao.getPaymentById(id);
    }
}
