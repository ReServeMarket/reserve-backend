package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_login_history")
public class UserLoginHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userLoginHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String loginIp;
    @Column(nullable = false)
    private LocalDateTime loggedInAt;
}