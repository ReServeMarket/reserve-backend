package api.user.controller.dto;

import com.reserve.security.security.TokenDataDto;
import lombok.*;

/**
 * 내부 테스트용 임시 토큰 발급 DTO 관리
 */

public class UserLoginDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String ci;
        private String phoneNumber;


    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long userId;
        private TokenDataDto tokenData;
    }
}
