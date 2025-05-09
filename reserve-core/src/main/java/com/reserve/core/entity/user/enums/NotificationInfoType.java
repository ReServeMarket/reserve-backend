package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NotificationInfoType {
    PAY_BANK_TRANSFER("무통장 입금 안내");

    private final String description;
}
