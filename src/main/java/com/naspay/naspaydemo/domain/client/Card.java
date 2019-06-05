package com.naspay.naspaydemo.domain.client;

import lombok.Data;

@Data
public class Card {

    private String cardholder;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
}
