package com.reserve.core.entity.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PersonalityType {
    OUTGOING("외향적인"),
    CUTE("애교있는"),
    HUMOROUS("유머있는"),
    KIND("친절한"),
    CALM("차분한"),
    POSITIVE("긍정적인"),
    INTELLIGENT("지적인"),
    QUIRKY("4차원"),
    PASSIONATE("열정적인"),
    THOUGHTFUL("사려깊은"),
    SERIOUS("진지한"),
    SENSITIVE("센스있는");

    private final String description;
}
