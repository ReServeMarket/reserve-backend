package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import com.reserve.core.entity.user.enums.PersonalityType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_personality")
public class UserPersonality extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPersonalityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PersonalityType personalityType;
}