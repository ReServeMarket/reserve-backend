package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatusType {
    PROFILE_REGISTRATION("프로필 등록 전") ,
    PROFILE_APPROVAL("프로필 승인 전") ,
    ACTIVE("활동") ,
    DORMANT("휴면") ,
    WITHDRAWN("탈퇴") ,
    BLOCKED("블락") ,
    REJECTED("반려") ;

    private final String description;
}
