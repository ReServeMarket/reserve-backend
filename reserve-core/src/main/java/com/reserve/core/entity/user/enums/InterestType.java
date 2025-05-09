package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InterestType {
    EXERCISE("운동"),
    SELF_IMPROVEMENT("자기개발"),
    READING("독서"),
    FOREIGN_LANGUAGE("외국어"),
    CAFE("카페"),
    COOKING("요리"),
    MUSIC("음악"),
    PLYING_INSTRUMENT("악기 연주"),
    WALKING("산책"),
    PETS("반려동물"),
    TRAVEL("여행"),
    FASHION("패션"),
    FOOD_TRAVEL("맛집 탐방"),
    MOVIES_OTT("영화/넷플릭스");

    private final String description;
}
