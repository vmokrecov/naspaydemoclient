package com.naspay.naspaydemo.services.impl;

import com.naspay.naspaydemo.configuration.properties.AuthServiceProperties;
import com.naspay.naspaydemo.domain.auth.Token;
import com.naspay.naspaydemo.services.AuthService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@EnableConfigurationProperties(AuthServiceProperties.class)
public class AuthServiceImpl implements AuthService {

    private final RestTemplate restTemplate;
    private final AuthServiceProperties properties;

    private Token accessToken;

    public AuthServiceImpl(RestTemplateBuilder builder, AuthServiceProperties properties) {
        this.restTemplate = builder
                .basicAuthentication(properties.getTerminalKey(), properties.getTerminalSecret())
                .build();
        this.properties = properties;
    }

    @Override
    public Token getAccessToken() {
        accessToken = Optional.ofNullable(accessToken).filter(Token::isValid).orElseGet(this::receiveTokenFromApi);
        return accessToken;
    }

    private Token receiveTokenFromApi() {
        @NotEmpty final String tokenUrl = this.properties.getTokenUrl();
        Token token = this.restTemplate.getForObject(tokenUrl, Token.class);
        return Token.builder()
                .accessToken(token.getAccessToken())
                .tokenType(token.getTokenType())
                .createAt(LocalDateTime.now())
                .expireAt(LocalDateTime.now().plusHours(8))
                .revokeAt(LocalDateTime.now().plusMinutes(15))
                .build();
    }
}
