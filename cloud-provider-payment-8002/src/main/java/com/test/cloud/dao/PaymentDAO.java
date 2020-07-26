package com.test.cloud.dao;

import com.test.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDAO {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
