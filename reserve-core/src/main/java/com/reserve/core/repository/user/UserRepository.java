package com.reserve.core.repository.user;

import com.reserve.core.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.interests " +
            "LEFT JOIN FETCH u.personalities " +
            "WHERE u.userId = :userId")
    Optional<User> findByUserUserId(@Param("userId") Long userId);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByCi(String ci);

}
