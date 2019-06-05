package com.naspay.naspaydemo.services;

import com.naspay.naspaydemo.domain.auth.Token;

public interface AuthService {

    Token getAccessToken();
}
