package com.reserve.core.repository.user;

import com.reserve.core.entity.user.IntroducedUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IntroducedUserProfileRepository extends JpaRepository<IntroducedUserProfile, Long> {

    @Query("SELECT iup FROM IntroducedUserProfile iup WHERE " +
            "iup.introducedUser.userId = :userId AND " +
            "iup.round = :round")
    List<IntroducedUserProfile> findIntroducedUserProfiles(Long userId, String round);

    @Query("SELECT iup FROM IntroducedUserProfile iup WHERE " +
            "iup.introducedUser.userId = :introducedUserId AND " +
            "iup.introducingUser.userId = :introducingUserId AND " +
            "iup.round = :round")
    Optional<IntroducedUserProfile> findByUserIdsAndRound(Long introducedUserId, Long introducingUserId, String round);

    @Query("SELECT CASE WHEN iup.introducedUser.userId = :userId " +
            "THEN iup.introducingUser.userId " +
            "ELSE iup.introducedUser.userId " +
            "END " +
            "FROM IntroducedUserProfile iup " +
            "WHERE (iup.introducedUser.userId = :userId OR iup.introducingUser.userId = :userId) AND iup.round < :round")
    Set<Long> findAlreadyIntroducedUserIds(Long userId, String round);

    @Query("SELECT COUNT(DISTINCT iup.round) " +
            "FROM IntroducedUserProfile iup " +
            "WHERE iup.introducedUser.userId = :userId AND iup.round < :round")
    Integer countByIntroducedRound(Long userId, String round);
}
