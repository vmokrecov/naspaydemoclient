package com.naspay.naspaydemo.controllers;

import com.naspay.naspaydemo.services.AuthService;
import com.naspay.naspaydemo.services.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    private final AuthService authService;
    private final Client client;

    public TransactionsController(AuthService authService, Client client) {
        this.authService = authService;
        this.client = client;
    }

    @GetMapping("getToken")
    public String getToken() {
        return authService.getAccessToken().getAccessToken();
    }

    @GetMapping("getTransactionStatus")
    public String getTransactionStatus(@RequestParam String id) {
        return client.getTransactionStatus(id);
    }
}
