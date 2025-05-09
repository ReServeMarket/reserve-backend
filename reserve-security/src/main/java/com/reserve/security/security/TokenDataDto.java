package com.reserve.security.security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TokenDataDto {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiredAt;
    private Long refreshTokenExpiredAt;
}