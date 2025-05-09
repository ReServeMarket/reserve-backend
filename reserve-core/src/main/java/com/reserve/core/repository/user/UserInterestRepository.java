package com.reserve.core.repository.user;

import com.reserve.core.entity.user.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
}
