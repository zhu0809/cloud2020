package com.test.cloud.entity;

import java.io.Serializable;


public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
