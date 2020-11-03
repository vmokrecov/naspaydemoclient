package com.naspay.naspaydemo.services.impl;

import com.naspay.naspaydemo.configuration.properties.AuthServiceProperties;
import com.naspay.naspaydemo.domain.client.Transaction;
import com.naspay.naspaydemo.services.Client;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotEmpty;

@Service
@EnableConfigurationProperties(AuthServiceProperties.class)
public class ClientImpl implements Client {

    private final AuthServiceProperties properties;
    private final RestTemplate restTemplate;

    public ClientImpl(RestTemplate restTemplate, AuthServiceProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public String getTransactionStatus(String id) {
        @NotEmpty final String apiUrl = properties.getApiUrl();
        try {
            Transaction tx = restTemplate.getForObject(apiUrl + "transactions/" + id, Transaction.class);

            return tx.getState();
        } catch (final HttpClientErrorException e) {
            switch (e.getStatusCode().value()) {
                case 400:
                    return "Invalid input";
                case 401:
                    return "Bearer token is missing or invalid";
                case 404:
                    return "Transaction not found";
                default:
                    return "Unknown error";
            }
        }
    }
}
