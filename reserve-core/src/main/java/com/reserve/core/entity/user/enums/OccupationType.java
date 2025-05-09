package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OccupationType {
    LARGE_COMPANY("대기업"),
    MEDIUM_COMPANY("중견기업"),
    PUBLIC_COMPANY("공기업/공무원"),
    STARTUP("스타트업"),
    SME("중소기업"),
    STUDENT("학생"),
    PROFESSIONAL("전문직 (회계사 등)"),
    MEDICAL("의료직 (간호사 등)"),
    RESEARCH("연구기술직"),
    EDUCATION("교육직"),
    BUSINESS("사업가"),
    OTHERS("기타");

    private final String description;
}
