package com.reserve.core.repository.user;

import com.reserve.core.entity.user.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFileRepository extends JpaRepository<UserFile, Long> {
}
