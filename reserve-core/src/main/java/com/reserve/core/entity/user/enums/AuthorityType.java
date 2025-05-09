package com.reserve.core.entity.user.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AuthorityType {
    // TODO : 현재 시큐리티 적용 범위내에서는 '사용자' 외에는 고려해야할 ROLE 이 있는지 ?
    ROLE_USER("사용자");

    private final String description;
}
