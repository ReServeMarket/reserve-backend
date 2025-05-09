package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import com.reserve.core.entity.user.enums.InterestType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_interest")
public class UserInterest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInterestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InterestType interestType;
}