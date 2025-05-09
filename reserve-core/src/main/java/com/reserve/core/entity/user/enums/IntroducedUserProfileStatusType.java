package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum IntroducedUserProfileStatusType {
    MATCHING("매칭중"),
    MATCHED("매칭완료");

    private final String description;
}
