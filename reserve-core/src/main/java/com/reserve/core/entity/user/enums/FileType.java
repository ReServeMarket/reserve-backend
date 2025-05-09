package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FileType {
    FACE_PHOTO("얼굴 사진"),
    FULL_BODY_PHOTO("전신 사진"),
    ATTRACTIVE_PHOTO("매력 어필 사진"),
    ID_VERIFICATION_DOCUMENT("신원 검증 서류");

    private final String description;
}

