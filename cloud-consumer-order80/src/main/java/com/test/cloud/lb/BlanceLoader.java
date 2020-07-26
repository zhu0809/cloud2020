package com.test.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface BlanceLoader {
    ServiceInstance instance(List<ServiceInstance> instances);
}
