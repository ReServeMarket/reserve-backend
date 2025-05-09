package com.reserve.core.repository.user;

import com.reserve.core.entity.user.IntroducedUserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IntroducedUserProfileJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void batchInsert(List<IntroducedUserProfile> profiles) {
        String sql = "INSERT INTO introduced_user_profile (introduced_user_id, introducing_user_id, introduced_at, introduced_user_profile_status_type, round) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, profiles, 100, (ps, profile) -> {
            ps.setLong(1, profile.getIntroducedUser().getUserId());
            ps.setLong(2, profile.getIntroducingUser().getUserId());
            ps.setTimestamp(3, Timestamp.valueOf(profile.getIntroducedAt()));
            ps.setString(4, profile.getIntroducedUserProfileStatusType().name());
            ps.setString(5, profile.getRound());
        });
    }
}