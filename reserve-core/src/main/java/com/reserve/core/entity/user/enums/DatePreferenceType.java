package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DatePreferenceType {
    FREQUENTLY("시간될 때마다 최대한 자주 보기"),
    ONCE_OR_TWICE_A_WEEK("일주일에 1~2번 데이트"),
    THREE_OR_FOUR_TIMES_A_WEEK("일주일에 3~4번 데이트"),
    FLEXIBLE_SCHEDULE("데이트 일정은 조율 가능");

    private final String label;
}
