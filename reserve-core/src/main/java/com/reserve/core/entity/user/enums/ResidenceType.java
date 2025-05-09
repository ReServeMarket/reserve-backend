package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResidenceType {
    SEOUL_NORTH("서울 북부"),
    SEOUL_EAST("서울 동부"),
    SEOUL_SOUTH("서울 남부"),
    SEOUL_WEST("서울 서부"),
    GYEONGGI_NORTH("경기 북부"),
    GYEONGGI_EAST("경기 동부"),
    GYEONGGI_SOUTH("경기 남부"),
    GYEONGGI_WEST("경기 서부"),
    INCHEON("인천");

    private final String description;
}
