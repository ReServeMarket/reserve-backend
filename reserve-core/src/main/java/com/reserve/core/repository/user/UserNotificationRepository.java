package com.reserve.core.repository.user;

import com.reserve.core.entity.user.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
}
