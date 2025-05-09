package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import com.reserve.core.entity.user.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<UserInterest> interests;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<UserPersonality> personalities;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<UserFile> photos;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String ci;
    @Enumerated(EnumType.STRING)
    private UserStatusType userStatusType;
    @Column(nullable = false)
    private String birthdate;
    private Integer height;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    @Enumerated(EnumType.STRING)
    private ResidenceType residenceType;
    private String detailResidence;
    private String lifestyle;
    private String messageToFuturePartner;
    private String nickname;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;
    @Enumerated(EnumType.STRING)
    private OccupationType occupationType;
    private String detailOccupation;
    @Enumerated(EnumType.STRING)
    private EducationType educationType;
    private Boolean isSmoking;
    @Enumerated(EnumType.STRING)
    private DrinkFrequencyType drinkFrequencyType;
    @Enumerated(EnumType.STRING)
    private DatePreferenceType datePreferenceType;
    private String mbti;
    private LocalDateTime registeredAt;
    private String referralCode;
    private LocalDateTime profileRegisteredAt;
    private LocalDateTime dormantAt;
    private LocalDateTime withdrawnAt;
    private LocalDateTime blockedAt;

    public boolean isActive() {
        return UserStatusType.ACTIVE.equals(userStatusType);
    }
}