package com.naspay.naspaydemo.configuration;

import com.naspay.naspaydemo.interceptors.RestTemplateHeaderModifierInterceptor;
import com.naspay.naspaydemo.services.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestClientConfig {

    private AuthService authService;

    public RestClientConfig(AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateHeaderModifierInterceptor(authService));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
