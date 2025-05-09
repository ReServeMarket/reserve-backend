package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_inflow")
public class UserInflow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInflowId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private String inflowPath;
    private String referralCode;
}