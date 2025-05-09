package com.reserve.security.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    /**
     * TODO : Security 와 관련되지 않는 의존은 추가하지 않는 방향으로 설계했지만 필요에 따라 추가
     */
    private final Key key;
    private final Long accessTokenPlusHour;
    private final Long refreshTokenPlusHour;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public JwtTokenProvider(
            @Value("${jwt.secret.key}") String key ,
            @Value("${jwt.access-token.plus-hour}") Long accessTokenPlusHour ,
            @Value("${jwt.refresh-token.plus-hour}") Long refreshTokenPlusHour ,
            AuthenticationManagerBuilder authenticationManagerBuilder
    ) {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.accessTokenPlusHour = accessTokenPlusHour;
        this.refreshTokenPlusHour = refreshTokenPlusHour;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    /**
     *  로그인 ID/PW 를 기반으로 인증하고 JWT 토큰을 발급하는 메서드
     */
    public TokenDataDto createToken(String userId, String phoneNumber) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, phoneNumber);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return createToken(authentication);
    }

    /**
     *  유저정보 기반 인증정보를 통해 AccessToken, RefreshToken 을 생성하는 메서드
     */
    private TokenDataDto createToken(Authentication authentication) {

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Date accessTokenExpiredAt = createExpiredAt(createExpiredLocalDateTime(accessTokenPlusHour));
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", authorities)
                .setExpiration(accessTokenExpiredAt)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        Date refreshTokenExpiredAt = createExpiredAt(createExpiredLocalDateTime(refreshTokenPlusHour));
        String refreshToken = Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(refreshTokenExpiredAt)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return TokenDataDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiredAt(accessTokenExpiredAt.getTime())
                .refreshTokenExpiredAt(refreshTokenExpiredAt.getTime())
                .build();
    }

    /**
     *  JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
     */
    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        if (claims.get("authorities") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("authorities").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    /**
     *  토큰 정보를 검증하는 메서드
     **/
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT Token");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT Token");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty");
        }
        return false;
    }

    /**
     * Request Header 에서 토큰 정보 추출
     */
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    /**
     * 현재 로그인한 유저의 SecurityContextHolder 로 부터 UserId 를 추출한다.
     */
    public static String getUserId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No Authentication found");
        }
        return authentication.getName();
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    private Date createExpiredAt(LocalDateTime expiredLocalDateTime) {
        return Date.from(
                expiredLocalDateTime.atZone(
                        ZoneId.systemDefault()
                ).toInstant()
        );
    }

    private LocalDateTime createExpiredLocalDateTime (Long plusHour) {
        return LocalDateTime.now().plusHours(plusHour);
    }

}