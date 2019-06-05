package com.naspay.naspaydemo.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Validated
@ConfigurationProperties("auth-service")
public class AuthServiceProperties {

    @NotEmpty
    private String tokenUrl;

    @NotEmpty
    private String apiUrl;

    @NotEmpty
    private String terminalKey;

    @NotEmpty
    private String terminalSecret;
}
