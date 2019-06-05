package com.naspay.naspaydemo.domain.client;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Transaction {

    private List<Link> links = null;
    private String paymentMethod;
    private BigDecimal amount;
    private String currency;
    private String merchantTransactionId;
    private String description;
    private ShippingAddress shippingAddress;
    private String type;
    private String state;
    private String id;
    private String created;
    private String updated;
    private String intent;
    private Customer customer;
    private Card card;
    private BillingAddress billingAddress;
    private String customerAccessToken;
    private String resultCode;
}
