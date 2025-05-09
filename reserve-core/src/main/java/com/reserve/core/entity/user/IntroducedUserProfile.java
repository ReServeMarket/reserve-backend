package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import com.reserve.core.entity.user.enums.IntroducedUserProfileStatusType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "introduced_user_profile")
public class IntroducedUserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long introducedUserProfileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "introduced_user_id")
    private User introducedUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "introducing_user_id")
    private User introducingUser;

    @Column(nullable = false)
    private LocalDateTime introducedAt;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IntroducedUserProfileStatusType introducedUserProfileStatusType;
    @Column(nullable = false)
    private String round;

    public static IntroducedUserProfile of(User meUser, User youUser, String currentRound) {
        return IntroducedUserProfile.builder()
                .introducedUser(meUser)
                .introducingUser(youUser)
                .introducedAt(LocalDateTime.now())
                .introducedUserProfileStatusType(IntroducedUserProfileStatusType.MATCHING)
                .round(currentRound)
                .build();
    }
}