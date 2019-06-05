package com.naspay.naspaydemo.interceptors;

import com.naspay.naspaydemo.domain.auth.Token;
import com.naspay.naspaydemo.services.AuthService;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    private AuthService authService;

    public RestTemplateHeaderModifierInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        Token token = authService.getAccessToken();
        httpRequest.getHeaders().add("Authorization", "Bearer " + token.getAccessToken());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
