package com.naspay.naspaydemo.domain.client;

import lombok.Data;

@Data
public class BillingAddress {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String countryCode;
}
