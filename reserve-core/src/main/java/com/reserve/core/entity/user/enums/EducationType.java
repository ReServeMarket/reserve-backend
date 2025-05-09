package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EducationType {
    HIGH_SCHOOL_GRADUATE("고등학교 졸업"),
    JUNIOR_COLLEGE_STUDENT("전문대 재학"),
    JUNIOR_COLLEGE_GRADUATE("전문대 졸업"),
    UNIVERSITY_STUDENT("대학교 재학"),
    UNIVERSITY_GRADUATE("대학교 졸업"),
    GRADUATE_SCHOOL_STUDENT("대학원 재학"),
    GRADUATE_SCHOOL_GRADUATE("대학원 졸업"),
    DOCTORAL_STUDENT("박사과정 진행"),
    DOCTORAL_GRADUATE("박사과정 수료");

    private final String description;
}
