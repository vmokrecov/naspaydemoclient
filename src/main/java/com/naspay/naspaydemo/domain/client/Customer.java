package com.naspay.naspaydemo.domain.client;

import lombok.Data;

@Data
public class Customer {

    private String merchantCustomerId;
    private String phone;
    private String email;
    private String countryCode;
    private String ip;
    private String userAgent;
}
