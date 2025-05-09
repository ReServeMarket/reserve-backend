package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DrinkFrequencyType {
    OFTEN("주 3회 이상"),
    SOMETIMES("주 2회 이상"),
    RARELY("월 1~2회"),
    NEVER("월 1회 이하");

    private final String description;
}
