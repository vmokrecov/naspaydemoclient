package com.naspay.naspaydemo.domain.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public final class Token {

    @JsonProperty("access_token")
    private final String accessToken;
    @JsonProperty("token_type")
    private final String tokenType;

    private final LocalDateTime createAt;
    private final LocalDateTime revokeAt;
    private final LocalDateTime expireAt;

    public static boolean isValid(Token token) {
        return !token.revokeAt.isBefore(LocalDateTime.now()) && !token.expireAt.isBefore(LocalDateTime.now());
    }
}
