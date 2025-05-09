package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NotificationType {
    SMS("문자 알림"),
    PUSH("PUSH 알림");

    private final String description;
}
